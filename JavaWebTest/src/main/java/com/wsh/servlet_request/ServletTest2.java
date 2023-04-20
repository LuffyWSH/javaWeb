package com.wsh.servlet_request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/ServletTest2")
public class ServletTest2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取所有的请求头名称
        //放回值是迭代器
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){//判断是否还有数据
            String key = headerNames.nextElement();
            //通过请求头的名称获取请求头的值
            String header = request.getHeader(key);
            System.out.println(key+":"+header);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
