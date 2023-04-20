package com.wsh.servlet_response;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/Servlet_Response9")
public class Servlet_Response9 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取文件真实路径（在服务器中的路径）
        //获取ServletContext
        ServletContext servletContext = this.getServletContext();
        String realPath1 = servletContext.getRealPath("/b.txt");
        /*

        /代表着"/Users/wushuhong/IdeaProjects/java_web/JavaWebTest/target/JavaWebTest-1.0-SNAPSHOT"
         */
        System.out.println(realPath1);

        //获取WEB-INF的里文件路径
        String realPath2 = servletContext.getRealPath("/WEB-INF/c.txt");
        System.out.println(realPath2);

        //获取src的里文件路径(获取不到)
        String realPath3 = servletContext.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println(realPath3);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
