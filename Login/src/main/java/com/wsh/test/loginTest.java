package com.wsh.test;

import com.wsh.dao.UserDaoImpl;
import com.wsh.domain.User;
import org.junit.Test;

public class loginTest {
    @Test
    public void login(){
        User login_user = new User();
        login_user.setUsername("luffy");
        login_user.setPassword("123456");
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.findUser(login_user);
        System.out.println(user);
    }
}
