package com.wsh.jdbc;

import com.wsh.utils.JDBC_Utils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 登录
 */
public class JDBC_Test8 {
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
        Statement statement =null;
        ResultSet resultSet =null;
        try {
            //连接数据库
            connection = JDBC_Utils.getConnection();
            //3、定义sql语句
            String sql = "select * from user where user = '"+ user_name +"' and password = '"+ user_password +"' ";
            //4、获得sql执行对象
            statement = connection.createStatement();
            //5、执行sql语句
            resultSet = statement.executeQuery(sql);
            //6、处理结果
            while (resultSet.next()){ //判断是否还有数据
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBC_Utils.close(statement, connection,resultSet);
        }
        return false;
    }
}
