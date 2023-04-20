package com.wsh.servlet;

import com.wsh.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Servlet_delete_select")
public class Servlet_delete_select extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得id数组
        String[] ids = request.getParameterValues("uid");
        //调用servive层
        UserServiceImpl userService = new UserServiceImpl();
        userService.delete_select(ids);
        //完成操作后重定向回到数据展示页面
        response.sendRedirect(request.getContextPath()+"/Servlet_FindUserByPage");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
