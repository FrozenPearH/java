package com.hlz25720

import java.sql.DriverManager
import java.text.SimpleDateFormat
import java.util.{Calendar, Date, Properties}

import org.apache.spark.rdd.JdbcRDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Dataset, Row, SaveMode, SparkSession}


object SparkJdbc {

//  计算三个月前的第一天
  def threeMonthAgo = {
    val cal = Calendar.getInstance();
    cal.set(Calendar.MONTH, new SimpleDateFormat("yyyy-MM-dd").format(new Date()).substring(5, 7).toInt - 3);
    cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DATE));
    new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime())
  }
//拿数据
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("sparkJdbc").setMaster("local")
    val sc = new SparkContext(conf)
    val spark = SparkSession.builder().getOrCreate()

    val jdbcRDD = new JdbcRDD(sc,
      () => {
        Class.forName("com.mysql.jdbc.Driver").newInstance()
        DriverManager.getConnection("jdbc:mysql://122.112.177.197:3306/practive_test", "hand_test", "hand_test")
      },
      "select * from sells WHERE uuid >= ? AND uuid <= ?",
      700000,
      782470,
      1,
      r => {
        val uuid = r.getInt(1)
        val period_name = r.getString(2)
        val period_year = r.getString(3)
        val period_num = r.getString(4)
        val item_id = r.getString(5)
        val area = r.getString(6)
        val buying_price = r.getBigDecimal(7)
        val sell_price = r.getBigDecimal(8)
        val sell_number = r.getInt(9)
        val last_update_date = r.getDate(10)
        (uuid,period_name, period_year,period_num,item_id,area,buying_price,sell_price,sell_number,last_update_date)
      }
    )

    //触发 action
    println(jdbcRDD.collect.toBuffer)
    //转换成DF
    import spark.implicits._
    val jdbcDF = jdbcRDD.toDF("uuid", "period_name", "period_year", "period_num", "item_id", "area", "buying_price", "sell_price", "sell_number", "last_update_date")
    //创建临时表
    jdbcDF.createOrReplaceTempView("sells")
    //展示数据
    jdbcDF.show
    //展示表结构
    jdbcDF.printSchema()

    val result: Dataset[Row] =spark.sql(" select uuid , period_name ,period_year , period_num , item_id , area ,sum((sell_price - buying_price) * sell_number) as day_profit , last_update_date from sells").filter($"last_update_date" >= threeMonthAgo)

    result.show()

//    写入mysql
    val prop=new Properties()
    prop.setProperty("user","hzero")
    prop.setProperty("password","hzero")
    result.write.mode(SaveMode.Overwrite).jdbc("jdbc:mysql://122.112.177.197:3306/practive_test","25720_test",prop)

    sc.stop()
    spark.stop()
  }
}