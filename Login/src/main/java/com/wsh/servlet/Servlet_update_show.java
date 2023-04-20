package com.wsh.servlet;

import com.wsh.domain.User;
import com.wsh.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Servlet_update_show")
public class Servlet_update_show extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得要修改的编号
        int id =Integer.parseInt(request.getParameter("id"));
        //调用Service层
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.updateShow(id);


        //利用session共享数据
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        session.setAttribute("id",id);
        //完成操作后重定向回到数据展示页面
        response.sendRedirect(request.getContextPath()+"/update.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
