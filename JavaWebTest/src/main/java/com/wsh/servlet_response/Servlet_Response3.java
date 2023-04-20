package com.wsh.servlet_response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet_Response3")
public class Servlet_Response3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决乱码问题
        //response.setCharacterEncoding("gbk");//这种方法要知道浏览器的编码方式，然后设置和它的一样，但是这种方法不现实
        //给客户端返回一个编码，让客户端根据我的字符集来改变它的字符集
        //response.setHeader("Content-Type","text/html;charset=UTF-8");
        //简化
        response.setContentType("text/html;charset=UTF-8");
        //获取字符输出流
        //PrintWriter pw = response.getWriter();
        //可以输出字符串，但是碰到html也会自动解析
        //pw.write("<h1>你好</h1>");

        //获取字节输出流
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write("你好".getBytes());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
