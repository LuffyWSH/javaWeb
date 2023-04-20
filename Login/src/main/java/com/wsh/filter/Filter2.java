package com.wsh.filter;

import com.wsh.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebFilter("/*")
public class Filter2 implements Filter {
    //创建一个集合用来存储敏感词
  private ArrayList<String> al = new ArrayList<String>();
    public void init(FilterConfig config) throws ServletException {
        //获得敏感词表，封装成集合对象
        //获得文件真实路径
        ServletContext servletContext = config.getServletContext();
        String realPath = servletContext.getRealPath("/WEB-INF/classes/Sensitive_Word.txt");
        BufferedReader br=null;
        try {
            //用I/O流读取数据
            br = new BufferedReader(new FileReader(realPath));
            String line;
            while ((line=br.readLine())!=null){
                al.add(line);
            }
            System.out.println(al);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //获取代理对象
        ServletRequest proxy_req =(ServletRequest) Proxy.newProxyInstance(
                req.getClass().getClassLoader(),
                req.getClass().getInterfaces(),
                new InvocationHandler() {
                            @Override
                            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                                //增强方法返回值
                                if(method.getName().equals("getParameter")){
                                   //调用真实对象获得请求参数
                                    String value =(String) method.invoke(req, args);
                                    if(value!=null){
                                        //判断请求参数是否包含敏感词
                                        for (String sensitive_word : al) {//遍历敏感词
                                            if(value.contains(sensitive_word)){//包含敏感词
                                                value = value.replaceAll(sensitive_word, "***");
                                            }
                                        }
                                    }
                                    return value;
                                }
                                return method.invoke(req, args);
                            }
                });
        //放行
        chain.doFilter(proxy_req,response);
    }
}
