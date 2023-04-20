package com.wsh.servlet_request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/ServletTest3")
public class ServletTest3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得请求方法
        String method = request.getMethod();
        System.out.println(method);//  GET
        //获得虚拟目录
        String contextPath = request.getContextPath();
        System.out.println(contextPath); //   /JavaWebTest
        //获得请求资源
        String servletPath = request.getServletPath();
        System.out.println(servletPath);//  /ServletTest1
        //获取请求URI  URI：统一资源标识符
        String requestURI = request.getRequestURI();
        System.out.println(requestURI); //  /JavaWebTest/ServletTest1
        //获取请求URL  URL:统一资源定位符
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL); //  http://localhost:8080/JavaWebTest/ServletTest1
        //获取协议及版本号
        String protocol = request.getProtocol();
        System.out.println(protocol);  // HTTP/1.1

        //获取所有的请求头名称
        System.out.println("=========================================");
        //放回值是迭代器
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){//判断是否还有数据
            String key = headerNames.nextElement();
            //通过请求头的名称获取请求头的值
            String header = request.getHeader(key);
            System.out.println(key+":"+header);
        }

        System.out.println("=========================================");

        //获得请求参数
        BufferedReader reader = request.getReader();
        //读数据
        String b;
        while ((b=reader.readLine())!=null){
            System.out.println(b);
        }
    }
}
