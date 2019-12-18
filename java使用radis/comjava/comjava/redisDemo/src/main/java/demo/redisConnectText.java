package demo;

import redis.clients.jedis.Jedis;

/**
 * <p>
 * 连接本地redis
 * </p>
 *
 * @author meixiang.wang@hand-china.com 2019-10-16-15:05
 */
public class redisConnectText {
	public static void main(String[] args) {
        /*
         *  默认端口名称为6379
         *  连接redis常见错误，因为防火墙没关，或者没有给redis访问端口放行
         *  远程连接redis，redis有自我保护模式，解决方法给redis设置密码，通过密码连接
        */

		//Jedis jedis = new Jedis("127.0.0.1",6379);
	//	jedis.set("name","tony");
	//	String name = jedis.get("name");
		//System.out.println("名称："+name);
		//关闭redis数据库连接
		//jedis.close();
		/**
		 * <p>通过redis连接池进行连接<p/>
		 *
		 * @param [args]
		 * @return void
		 * @author meixiang.wang@hand-china.com
		 * @date 2019/10/16
		 */
		String key = "rule_engine:0:RuleCode2:RULE_EXECUTOR:ruleComponent:field";
		String oo=key.substring(key.lastIndexOf(":",key.lastIndexOf(":")-1)+1);
		String a = oo.substring(0,oo.indexOf(":"));
		System.out.println(a);

		System.out.println(oo);
	}
}
