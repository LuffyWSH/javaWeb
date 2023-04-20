package com.wsh.ajax;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/Servlet_register")
public class Servlet_register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //响应有中文，所以设置响应编码方式
        response.setContentType("text/html;charset=utf-8");
        //获得请求数据
        String username = request.getParameter("username");
        //定义一个map用来存返回数据
        Map<String,Object> hm=new HashMap<String,Object>();
        //判断
        if("wsh".equals(username)){
            //用户名存在
            hm.put("userExist",true);
            hm.put("msg","用户名已存在");
        }else {
            //用户名不存在
            hm.put("userExist",false);
            hm.put("msg","用户名可用");
        }
        //创建Jackson的核心对象 ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        //将map集合变成json数据
        objectMapper.writeValue(response.getWriter(),hm);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
