package com.wsh.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ServletSession4")
public class ServletSession4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得表单数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
        //获得正确验证码
        HttpSession session = request.getSession();
        String correct_code =(String) session.getAttribute("code");
        //初始化session
        session.removeAttribute("code");
        session.removeAttribute("code_error");
        session.removeAttribute("userpw_error");
        session.removeAttribute("user");
        //比较验证码是否正确
        if (!correct_code.equalsIgnoreCase(code)) {
            //验证码不正确
            //用session存储要交互的数据
            session.setAttribute("code_error","验证码错误");
            //请求转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
        //验证码正确,判断用户名和密码是否正确
        if("wsh".equals(username) & "123456".equals(password)){
            //正确
            //用session存储要交互的数据
            session.setAttribute("user",username);
            //重定向到成功页面
            response.sendRedirect("/JavaWebTest/success.jsp");
        }else {
            //不正确
            //用session存储要交互的数据
            session.setAttribute("userpw_error","用户名或密码错误");
            //请求转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
