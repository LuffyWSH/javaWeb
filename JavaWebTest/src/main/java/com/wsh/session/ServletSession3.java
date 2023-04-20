package com.wsh.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
/*
实现浏览器关闭后，服务器没关闭，获的还是同一个session
 */
@WebServlet("/ServletSession3")
public class ServletSession3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session对象
        HttpSession session = request.getSession();
        //设置session值
        session.setAttribute("msg","usc");
        //获取session的id
        String id = session.getId();
        //手动将session值存入cookie中
        Cookie cookie = new Cookie("JSESSIONID",id);
        //设置cookie存活时间
        cookie.setMaxAge(60*60);//存活时间为1个小时
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
