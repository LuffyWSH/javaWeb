package com.wsh.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletCookie3")
public class ServletCookie3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建多个cookie

        //创建cookie对象
        Cookie cookie1 = new Cookie("wsh", "usc");
        //发送cookie给浏览器
        response.addCookie(cookie1);

        //创建cookie对象
        Cookie cookie2 = new Cookie("name", "wsh");
        //发送cookie给浏览器
        response.addCookie(cookie2);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
