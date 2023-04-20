package com.wsh.jdbc_template;

import com.wsh.utils.Druid_utils;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplate_Test1 {
    public static void main(String[] args) {
        //创建JdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(Druid_utils.dataSource());
        //调用方法
        String sql = "update account set balance = 3000 where id =?";
        int count = jdbcTemplate.update(sql, 2);
        System.out.println(count);

    }
}
