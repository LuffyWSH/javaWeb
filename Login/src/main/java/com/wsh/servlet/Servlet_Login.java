package com.wsh.servlet;

import com.wsh.domain.User;
import com.wsh.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Servlet_Login")
public class Servlet_Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //获取表单数据
        String username = request.getParameter("user");
        String password = request.getParameter("password");
        String verifycode = request.getParameter("verifycode");
        //获取正确的验证码
        HttpSession session = request.getSession();
        String code =(String) session.getAttribute("code");
        //判断验证码是否正确
        if(code==null || verifycode==null || !code.equalsIgnoreCase(verifycode)){
            request.setAttribute("error","验证码错误,请重新登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        //一获取密码就移除，防止二次利用
        session.removeAttribute("code");

        //封装对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //调用service
        UserServiceImpl userService = new UserServiceImpl();
        User user1 = userService.findUser(user);

        //判断得到的结果是不是null
        if(user1!=null){
            //不是null，表明登录成功
            session.setAttribute("user",user1);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            //是null,表明登录失败
            request.setAttribute("error","用户名和密码不符,请重新登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
