package com.wsh.servlet;

import com.wsh.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Servlet_delete")
public class Servlet_delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得要删除的编号
        int id =Integer.parseInt(request.getParameter("id"));
        //调用Service层
        UserServiceImpl userService = new UserServiceImpl();
        userService.deleteUser(id);

        //完成操作后重定向回到数据展示页面
        response.sendRedirect(request.getContextPath()+"/Servlet_FindUserByPage");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
