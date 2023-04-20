package com.wsh.service.impl;

import com.wsh.dao.impl.UserDaoImpl;
import com.wsh.domain.User;
import com.wsh.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoImpl userDao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
