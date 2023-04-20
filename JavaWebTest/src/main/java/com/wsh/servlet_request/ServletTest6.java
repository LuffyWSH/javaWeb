package com.wsh.servlet_request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletTest6")
public class ServletTest6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("/ServletTest6被访问了");
        /*//通过request对象获取请求转发器对象
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ServletTest7");
        //转发
        requestDispatcher.forward(request,response);*/
        //共享数据
        request.setAttribute("name","wsh");

        request.getRequestDispatcher("/ServletTest7").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
