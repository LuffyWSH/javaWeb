package com.wsh.jdbc;

import com.wsh.utils.JDBC_Utils;

import java.sql.*;
import java.util.Scanner;

/*
请输入用户名：hhhhhh
请输入密码：a' or 'a' = 'a
登录成功
问题：sql注入
解决sql注入问题：使用PreparedStatement对象来解决
 */
public class JDBC_Test9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String user_name = scanner.nextLine();
        System.out.print("请输入密码：");
        String user_password = scanner.nextLine();
        boolean flag = getConnection(user_name, user_password);
        if(flag){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }

    private static boolean getConnection(String user_name, String user_password) {
        Connection connection =null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;
        try {
            //连接数据库
            connection = JDBC_Utils.getConnection();
            //3、定义sql语句
            String sql = "select * from user where user = ? and password =? ";
            //4、获得sql执行对象
            preparedStatement = connection.prepareStatement(sql);
            //给？赋值
            preparedStatement.setString(1,user_name);
            preparedStatement.setString(2,user_password);
            //5、执行sql语句
            resultSet = preparedStatement.executeQuery();
            //6、处理结果
            while (resultSet.next()){ //判断是否还有数据
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBC_Utils.close(preparedStatement, connection,resultSet);
        }
        return false;
    }
}
