package com.wsh.dao;

import com.wsh.domain.User;
import com.wsh.utils.Druid_Utils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    //从数据库中加载数据
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(Druid_Utils.dataSource());

    public User user_login(User login_user){
        //定义sql语句
        String sql="select * from user where username=? and password=?";
        User user ;
        try {
            //得到结果List集合
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), login_user.getUsername(), login_user.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }
}
