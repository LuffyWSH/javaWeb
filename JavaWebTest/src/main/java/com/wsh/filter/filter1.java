package com.wsh.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
public class filter1 implements Filter {
    @Override
    //init:在服务器启动后，会创建Filter对象，然后调用init方法。只执行一次。用于加载资源
    public void init(FilterConfig filterConfig) throws ServletException {
        //Filter.super.init(filterConfig);

    }

    @Override
    //doFilter:每一次请求被拦截资源时，会执行。执行多次
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter1开始.....");
        chain.doFilter(request,response);
        System.out.println("doFilter1结束.....");
    }

    @Override
    //destroy:在服务器关闭后，Filter对象被销毁。如果服务器是正常关闭，则会执行destroy方法。只执行一次。用于释放资源
    public void destroy() {
        //Filter.super.destroy();
    }
}
