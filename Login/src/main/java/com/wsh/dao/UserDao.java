package com.wsh.dao;

import com.wsh.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public List<User> findAll();
    public User findUser(User login_user);
    public void insertUser(User user);
    public void deleteUser(int id);
    public User updateShow(int id);
    public void updateUser(User user);
    public int getTotalCount(Map<String, String[]> parameterMap);
    public List<User> getUserlist(int startId, int row, Map<String, String[]> parameterMap);
}
