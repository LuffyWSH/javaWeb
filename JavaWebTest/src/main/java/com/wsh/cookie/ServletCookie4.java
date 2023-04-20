package com.wsh.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletCookie4")
public class ServletCookie4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置cookie存活时间

        //创建cookie对象
        Cookie cookie1 = new Cookie("wsh", "usc");
        //设置时间
        cookie1.setMaxAge(300);
        //cookie1.setMaxAge(-3);
        //cookie1.setMaxAge(0);
        //发送cookie给浏览器
        response.addCookie(cookie1);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
