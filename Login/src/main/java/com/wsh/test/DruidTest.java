package com.wsh.test;

import com.wsh.domain.User;
import com.wsh.service.UserServiceImpl;
import org.junit.Test;

import java.util.List;

public class DruidTest {
    @Test
    public void test1(){
        UserServiceImpl userService = new UserServiceImpl();
        List<User> all = userService.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
}
