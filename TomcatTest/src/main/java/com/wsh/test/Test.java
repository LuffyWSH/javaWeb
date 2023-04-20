package com.wsh.test;

import com.wsh.domain.User;
import com.wsh.service.impl.UserServiceImpl;

import java.util.List;

public class Test {
    @org.junit.Test
    public void test1(){
        UserServiceImpl userService = new UserServiceImpl();
        List<User> all = userService.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
}
