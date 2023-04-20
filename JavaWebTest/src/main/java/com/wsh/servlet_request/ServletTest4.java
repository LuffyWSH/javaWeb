package com.wsh.servlet_request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * 不管什么请求方式都能获得请求参数
 */
@WebServlet("/ServletTest4")
public class ServletTest4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //根据参数名称获取参数值
        String username = req.getParameter("username");
        System.out.println("username"+username);
        System.out.println("========================================");

        //根据参数名称获取参数值的数组
        System.out.print("hobby:");
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.print(hobby+",");
        }
        System.out.println("========================================");

        //获取所有参数
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String key_name = parameterNames.nextElement();
            String parameter = req.getParameter(key_name);
            System.out.println(key_name+":"+key_name);
        }
        System.out.println("========================================");
        //获取所有参数
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> keySets = parameterMap.keySet();
        for (String keySet : keySets) {
            //根据键获得值数组
            String[] parameterValues = req.getParameterValues(keySet);
            //遍历数组
            System.out.print(keySet+":");
            for (String parameterValue : parameterValues) {
                System.out.print(parameterValue+",");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }
}
