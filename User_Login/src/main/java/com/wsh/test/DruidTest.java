package com.wsh.test;

import com.wsh.dao.UserDao;
import com.wsh.domain.User;
import com.wsh.utils.Druid_Utils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class DruidTest {
    @Test
    public void test1(){
        User user = new User("wsh", "123456");
        UserDao userDao = new UserDao();
        User user1 = userDao.user_login(user);
        System.out.println(user1);
    }
    @Test
    public void test2(){
        //从数据库中加载数据
        JdbcTemplate jdbcTemplate = new JdbcTemplate(Druid_Utils.dataSource());
        //定义sql语句
        String sql = "select * from user";
        //得到结果List集合
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        //打印数据
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }
}
