package com.wsh.servlet_request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ServletTest1")
public class ServletTest1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得请求方法
        String method = request.getMethod();
        System.out.println(method);//  GET
        //获得虚拟目录
        String contextPath = request.getContextPath();
        System.out.println(contextPath); //   /JavaWebTest
        //获得请求资源
        String servletPath = request.getServletPath();
        System.out.println(servletPath);//  /ServletTest1
        //获取get方式的请求参数
        String queryString = request.getQueryString();
        System.out.println(queryString); // null
        //获取请求URI  URI：统一资源标识符
        String requestURI = request.getRequestURI();
        System.out.println(requestURI); //  /JavaWebTest/ServletTest1
        //获取请求URL  URL:统一资源定位符
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL); //  http://localhost:8080/JavaWebTest/ServletTest1
        //获取协议及版本号
        String protocol = request.getProtocol();
        System.out.println(protocol);  // HTTP/1.1


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
