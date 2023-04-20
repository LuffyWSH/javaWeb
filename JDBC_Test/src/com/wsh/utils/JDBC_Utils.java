package com.wsh.utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBC_Utils {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    //文件的读取，只需要读取一次，就放在static静态块中
    static {
        //1. 创建Properties集合类。
        Properties properties = new Properties();
        try {
            //2. 加载文件
            properties.load(new FileReader("JDBC_Test/src/user.Properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //3. 获取数据，赋值
        driver = (String) properties.get("driver");
        url = (String) properties.get("url");
        user = (String) properties.get("user");
        password = (String) properties.get("password");
        //1、注册驱动（加载驱动类）
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取驱动，连接数据库
    public static Connection getConnection(){
        Connection connection =null;
        try {
            //2、获得驱动对象（连接数据库）
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //关闭资源
    public static void close(Statement statement, Connection connection){
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

    //关闭资源
    public static void close(Statement statement, Connection connection, ResultSet resultSet){
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
        if(resultSet !=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
