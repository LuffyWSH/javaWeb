package com.wsh.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletCookie5")
public class ServletCookie5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //cookie共享
        //创建cookie对象
        Cookie cookie1 = new Cookie("wsh", "usc");
        //设置访问路径(默认路径是当前虚拟目录)
        cookie1.setPath("/");
        //发送cookie给浏览器
        response.addCookie(cookie1);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
