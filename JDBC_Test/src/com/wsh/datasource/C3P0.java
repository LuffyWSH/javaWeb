package com.wsh.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3P0 {
    public static void main(String[] args) throws SQLException {
        //1、创建数据库连接池对象(默认)
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
            /*//1.1、获取指定数据库连接池对象
            ComboPooledDataSource comboPooledDataSource1 = new ComboPooledDataSource("otherc3p0");*/
        //2、获取连接对象
        Connection connection = comboPooledDataSource.getConnection();
            /*//2.1、获取连接对象
            Connection connection1 = comboPooledDataSource1.getConnection();*/
        System.out.println(connection);
    }

}
