package com.wsh.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsh.domain.Province;
import com.wsh.service.impl.ProvinceServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*//1、不用接收参数，直接调用service层查询
        ProvinceServiceImpl provinceService = new ProvinceServiceImpl();
        List<Province> provinces = provinceService.searchProvince();

        //2、将list集合的java数据变成json数据
        //2.1、创建Jackson的核心对象 ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        //2.2、转换
        String provincesString = objectMapper.writeValueAsString(provinces);*/

        //用redis
        ProvinceServiceImpl provinceService = new ProvinceServiceImpl();
        String allJson = provinceService.findAllJson();

        //3、设置编码方式将数据返回给页面
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(allJson);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
