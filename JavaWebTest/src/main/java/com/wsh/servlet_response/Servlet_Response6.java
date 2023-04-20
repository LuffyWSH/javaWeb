package com.wsh.servlet_response;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet_Response6")
public class Servlet_Response6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取MIME类型
        //1、得到ServletContext对象
        ServletContext servletContext = this.getServletContext();
        //2、定义一个文件
        String file="a.jpg";
        //3、获取文件类型
        String mimeType = servletContext.getMimeType(file);
        //4、打印
        System.out.println(mimeType);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
