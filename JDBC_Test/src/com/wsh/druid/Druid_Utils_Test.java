package com.wsh.druid;

import com.wsh.utils.Druid_utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Druid_Utils_Test {
    public static void main(String[] args) {
        Connection connetion =null;
        PreparedStatement preparedStatement =null;
        try {
            //获取连接
            connetion = Druid_utils.getConnetion();
            //定义sql语句
            String sql = "insert into account values(null,?,?)";
            //获得执行sql语句对象
            preparedStatement = connetion.prepareStatement(sql);
            //给sql语句赋值
            preparedStatement.setString(1,"luffy");
            preparedStatement.setInt(2,4000);
            //执行sql语句
            int i = preparedStatement.executeUpdate();
            //处理结果
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Druid_utils.close(preparedStatement,connetion);
        }
    }
}
