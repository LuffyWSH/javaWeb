package com.wsh.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Druid {
    public static void main(String[] args) throws Exception {
        //1、定义配置文件

        //2、加载配置文件
        Properties pro = new Properties();
        pro.load(new FileReader("JDBC_Test/src/druid.properties"));
        //或者这样加载配置文件
        /*InputStream resourceAsStream = Druid.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(resourceAsStream);*/
        //3、获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
        //4、获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
