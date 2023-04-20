package com.wsh.service;

import com.wsh.dao.UserDaoImpl;
import com.wsh.domain.PageBean;
import com.wsh.domain.User;
import com.wsh.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    //调用dao层查询数据
    UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findUser(User login_user) {
        return userDao.findUser(login_user);
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public User updateShow(int id) {
        return userDao.updateShow(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void delete_select(String[] ids) {
        if(ids!=null & ids.length>0){
            for (String id : ids) {
                userDao.deleteUser(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserbypage(String currentPage, String rows, Map<String, String[]> parameterMap) {
        //初始化页码
        if(currentPage==null || "".equals(currentPage)){
            currentPage="1";
        }
        if(rows==null || "".equals(rows)){
            rows="5";
        }
        int row=Integer.parseInt(rows);//将每页显示条数变成int类型
        int current_page=Integer.parseInt(currentPage);//将当前页码变成int类型
        //对第1页进行判断
        if(current_page<1){
            current_page=1;
        }
        //1、创建PageBean<User>对象
        PageBean<User> pageBean = new PageBean<>();
        //2、给pageBean赋值
        //获得总记录数
        int totalCount=userDao.getTotalCount(parameterMap);
        //计算得到总页码数
        int totalPage=0;
        if(totalCount % row == 0){
            totalPage=totalCount / row;
        }else {
            totalPage=(totalCount / row)+1;
        }
        //对最后一页进行判断
        if(current_page>totalPage){
            current_page=totalPage;
        }
        //获得每页数据集合
        int startId=(current_page-1)*row;//获得起始数据id
        List<User> lists=userDao.getUserlist(startId,row,parameterMap);

        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalPage);
        pageBean.setList(lists);
        pageBean.setCurrentPage(current_page);
        pageBean.setRows(row);
        return pageBean;
    }
}
