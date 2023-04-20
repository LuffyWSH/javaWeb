package com.wsh.jdbc;

import com.wsh.domain.User;

import java.sql.*;
import java.util.ArrayList;

public class JDBC_Test5 {
    public static void main(String[] args)  {
        Connection connection =null;
        Statement statement =null;
        try {
            //1、注册驱动（加载驱动类）
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2、获得驱动对象（连接数据库）
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test2", "root", "12345678");
            //3、定义sql语句
            String sql = "select * from account";
            //4、获得sql执行对象
            statement = connection.createStatement();
            //5、执行sql语句
            ResultSet resultSet = statement.executeQuery(sql);
            //6、处理结果
            //创建对象
            User user = new User();
            //创建集合
            ArrayList<User> al=new ArrayList<>();
            //循环判断游标是否是最后一行末尾
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                double balance = resultSet.getDouble("balance");
                user.setId(id);
                user.setName(name);
                user.setBalance(balance);
                al.add(user);
            }
            System.out.println(al);
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
