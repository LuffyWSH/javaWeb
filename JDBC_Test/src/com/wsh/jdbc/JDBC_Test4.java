package com.wsh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Test4 {
    public static void main(String[] args)  {
        Connection connection =null;
        Statement statement =null;
        try {
            //1、注册驱动（加载驱动类）
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2、获得驱动对象（连接数据库）
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test2", "root", "12345678");
            //3、定义sql语句
            String sql = "delete from account where id=3";
            //4、获得sql执行对象
            statement = connection.createStatement();
            //5、执行sql语句
            int result = statement.executeUpdate(sql);
            //6、处理结果
            System.out.println(result);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7、关闭资源
            if(statement !=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection !=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
