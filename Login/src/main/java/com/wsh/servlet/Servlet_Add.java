package com.wsh.servlet;

import com.wsh.domain.User;
import com.wsh.service.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/Servlet_Add")
public class Servlet_Add extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //获取添加的表单数据
        Map<String, String[]> parameterMap = request.getParameterMap();
        //创建对象
        User user = new User();
        //利用工具将获得的表单数据封装成对象
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用service层
        UserServiceImpl userService = new UserServiceImpl();
        userService.insertUser(user);

        //完成操作后重定向回到数据展示页面
        response.sendRedirect(request.getContextPath()+"/Servlet_FindUserByPage");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
