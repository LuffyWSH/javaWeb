package com.wsh.service;

import com.wsh.domain.PageBean;
import com.wsh.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<User> findAll();
    public User findUser(User login_user);
    public void insertUser(User user);
    public void deleteUser(int id);
    public User updateShow(int id);
    public void updateUser(User user);
    public void delete_select(String[] ids);
    PageBean<User> findUserbypage(String currentPage, String rows, Map<String, String[]> parameterMap);
}
