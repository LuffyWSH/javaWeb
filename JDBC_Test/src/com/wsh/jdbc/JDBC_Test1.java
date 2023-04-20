package com.wsh.jdbc;

import java.sql.*;

public class JDBC_Test1 {
    public static void main(String[] args)  {
        Connection connection = null;
        Statement statement =null;
        try {
            //1、注册驱动(加载驱动类)
            //mysql5之后的驱动jar包可以省略注册驱动的步骤。不过建议还是写
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2、获取数据库对象（连接数据库）
            //如果连接的是本机mysql服务器，并且mysql服务默认端口是3306，则url可以简写为：jdbc:mysql:///数据库名称
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test2", "root", "12345678");
            //3、定义sql语句
            String sql="update account set balance = 100 where id = 1";
            //4、获取执行sql语句对象
            statement = connection.createStatement();
            //5、执行sql语句
            /*
            1. boolean execute(String sql) ：可以执行任意的sql 了解
            2. int executeUpdate(String sql) ：执行DML（insert、update、delete）语句、DDL(create，alter、drop)语句
            3. ResultSet executeQuery(String sql) ：执行DQL（select)语句
            */
            int i = statement.executeUpdate(sql);
            //返回值：影响的行数，可以通过这个影响的行数判断DML语句是否执行成功 返回值>0的则执行成功，反之，则失败。
            //6、处理结果
            System.out.println(i);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            //7、释放资源
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
