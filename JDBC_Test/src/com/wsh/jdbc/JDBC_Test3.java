package com.wsh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Test3 {
    public static void main(String[] args) {
        Connection connection =null;
        Statement statement =null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取驱动对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test2", "root", "12345678");
            //定义sql语句
            String sql ="update account set balance = 100 where id=2";
            //获取执行sql对象
            statement = connection.createStatement();
            //执行sql对象
            int result = statement.executeUpdate(sql);
            //处理结果
            System.out.println(result);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
