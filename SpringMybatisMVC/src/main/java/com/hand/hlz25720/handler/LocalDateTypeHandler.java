package com.hand.hlz25720.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class LocalDateTypeHandler implements TypeHandler<LocalDate> {

    @Override
    public void setParameter(PreparedStatement preparedStatement , int index, LocalDate localDate, JdbcType jdbcType) throws SQLException {
        // 该方法适用于 INSERT 、UPDATE 、DELETE 、SELECT 等操作中为参数占位符设置值
        java.sql.Date date = null ;
        if( localDate != null ) {
            // 通过 java.sql.Date 类中的 静态方法 valueOf 可以将 LocalDate 实例转换为 java.sql.Date 实例
            date = java.sql.Date.valueOf( localDate );
        }
        preparedStatement.setDate( index , date ); // 设置参数占位符的值
    }

    @Override
    public LocalDate getResult(ResultSet resultSet, String columnLabel ) throws SQLException {
        // 根据 查询结果中的 列名 或 列的别名 来获取指定列的值
        java.sql.Date date = resultSet.getDate( columnLabel );
        LocalDate birthdate = null ;
        if( date != null ) {
            birthdate = date.toLocalDate();
        }
        return birthdate;
    }

    @Override
    public LocalDate getResult(ResultSet resultSet, int columnIndex ) throws SQLException {
        // 根据 查询结果中的 列的索引 来获取指定列的值
        java.sql.Date date = resultSet.getDate( columnIndex );
        LocalDate birthdate = null ;
        if( date != null ) {
            birthdate = date.toLocalDate();
        }
        return birthdate;
    }

    @Override
    public LocalDate getResult( CallableStatement callableStatement, int paramIndex ) throws SQLException {
        LocalDate localDate = null ;
        java.sql.Date date = callableStatement.getDate( paramIndex );
        if( date != null ) {
            localDate = date.toLocalDate();
        }
        return localDate;
    }

}
