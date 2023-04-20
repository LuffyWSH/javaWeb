package com.wsh.servlet_response;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet_Response5")
public class Servlet_Response5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ServletContext
        //法一：
        ServletContext servletContext1 = request.getServletContext();
        System.out.println(servletContext1);

        //法二
        ServletContext servletContext2 = this.getServletContext();
        System.out.println(servletContext2);

        //比较是否是同一个对象
        System.out.println(servletContext1==servletContext2);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
