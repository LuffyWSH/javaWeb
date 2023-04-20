package com.wsh.dao.impl;

import com.wsh.dao.UserDao;
import com.wsh.domain.User;
import com.wsh.utils.Druid_Utils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    //从数据库中加载数据
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(Druid_Utils.dataSource());
    @Override
    public List<User> findAll() {
        //定义sql语句搜索所有用户
        String sql="select * from user1 ";
        List<User> list;
        try {
            //得到结果List集合
            list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }
}
