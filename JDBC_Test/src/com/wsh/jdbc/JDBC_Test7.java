package com.wsh.jdbc;

import com.wsh.utils.JDBC_Utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
/*
使用工具类JDBC_Utils
 */
public class JDBC_Test7 {
    public static void main(String[] args) {
        Connection connection =null;
        Statement statement =null;
        try {
            //连接数据库
            connection = JDBC_Utils.getConnection();
            //3、定义sql语句
            String sql = "insert into account values(null ,'wsh',1000)";
            //4、获得sql执行对象
            statement = connection.createStatement();
            //5、执行sql语句
            int result = statement.executeUpdate(sql);
            //6、处理结果
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC_Utils.close(statement,connection);
        }
    }
}
