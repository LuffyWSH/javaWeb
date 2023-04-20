package com.wsh.servlet;

import com.wsh.domain.PageBean;
import com.wsh.domain.User;
import com.wsh.service.UserServiceImpl;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/Servlet_FindUserByPage")
public class Servlet_FindUserByPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //2、获取数据
        //获取当前页面
        String currentPage = request.getParameter("currentPage");
        //获取每页显示条数
        String rows = request.getParameter("rows");

        //获取条件查询的参数
        Map<String, String[]> parameterMap = request.getParameterMap();

        //3、调用service
        UserServiceImpl userService = new UserServiceImpl();
        PageBean<User> pb =userService.findUserbypage(currentPage,rows,parameterMap);
        //4、将pageBean返回list.jsp页面展示
        request.setAttribute("pb",pb);
        request.setAttribute("parameterMap",parameterMap);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
