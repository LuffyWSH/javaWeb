package com.wsh.servlet;

import com.wsh.dao.UserDao;
import com.wsh.domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //获得用户登录数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //将用户封装成对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        /*//用工具类
        //获得数据
        Map<String, String[]> parameterMap = request.getParameterMap();
        //创建对象
        User user = new User();
        //使用BeanUtils封装
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }*/


        //将用户装给User_Dao判断是否存在
        UserDao userDao = new UserDao();
        User login_user = userDao.user_login(user);
        System.out.println(login_user);
        if(login_user!=null){
            request.setAttribute("user",login_user);
            //转到登录成功页面
            request.getRequestDispatcher("/Servlet1").forward(request,response);
        }else {
            //转到登录失败页面
            request.getRequestDispatcher("/Servlet2").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
