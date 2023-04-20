package com.wsh.servlet_response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Servlet_Response1")
public class Servlet_Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("/Servlet_Response1..................");
        //实现重定向
       /* //法一：
        //1.设置状态码
        response.setStatus(302);
        //2、设置路径（请求头）
        response.setHeader("location","/JavaWebTest/Servlet_Response2");
        */
        //法二
        response.sendRedirect("/JavaWebTest/Servlet_Response2");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
