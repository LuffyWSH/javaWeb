package com.wsh.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Druid_Utils {
    private static DataSource ds;
    static {
        try {
            //加载配置文件
            Properties properties = new Properties();
            properties.load(new FileReader("/Users/wushuhong/IdeaProjects/java_web/User_Login/src/main/resources/druid.properties"));
            //获取连接池
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnetion() throws SQLException {
        return ds.getConnection();
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
                connection.close();//归还连接
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
                connection.close();  //归还连接
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

    //获取连接池
    public static DataSource dataSource(){
        return ds;
    }
}
