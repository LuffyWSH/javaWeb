package com.wsh.filter;

import com.wsh.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class Filter1 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //强转
        HttpServletRequest req =(HttpServletRequest) request;

        //获取请求资源的路径
        String requestURI = req.getRequestURI();

        //过滤登录资源
        if(requestURI.contains("/login.jsp") || requestURI.contains("/Servlet_Login") || requestURI.contains("/css")|| requestURI.contains("/fonts")|| requestURI.contains("/img") || requestURI.contains("/js") || requestURI.contains("/Servlet_Code")){
            //用户想访问登录资源，放行
            chain.doFilter(request, response);
        }else {
            //用户想访问其他资源，判断是否已经登录过了
            HttpSession session = req.getSession();
            User user =(User) session.getAttribute("user");
            //判断user是否为空
            if(user!=null){
                //不为空，证明已经登录过了
                chain.doFilter(request, response);
            }else {
                //为空，证明还没登录过，跳转到登录页面
                req.setAttribute("error","您还没登录，请先登录");
                req.getRequestDispatcher("/login.jsp").forward(req,response);
            }
        }
    }
}
