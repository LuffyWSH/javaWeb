package com.wsh.dao;

import com.wsh.domain.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();
}
