package com.wsh.cookie;

import javafx.util.converter.LocalDateTimeStringConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet("/ServletCookie6")
public class ServletCookie6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应数据的格式和编码方式
        response.setContentType("text/html;charset=UTF-8");
        //定义输出流
        PrintWriter pw = response.getWriter();
        //得到当前时间
        LocalDateTime now = LocalDateTime.now();
        //创建时间模板
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        //获得当前时间的字符串
        String time_value = now.format(dateTimeFormatter);
        //有特殊字符"空格"，所以对时间进行编码
        time_value = URLEncoder.encode(time_value,"utf-8");
        //获得cookie
        Cookie[] cookies = request.getCookies();
        String value =null;//定义cookie的值
        if(cookies!=null && cookies.length>0){
            //遍历cookies
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("lastTime")){
                    //获取到上次登录的时间
                    value = cookie.getValue();
                    //对时间进行解码
                    value = URLDecoder.decode(value, "utf-8");
                    //重新设置cookie的值
                    cookie.setValue(time_value);
                    //设置cookie存活时间
                    cookie.setMaxAge(60*60*24*30);//一个月
                    response.addCookie(cookie);
                    break;
                }
            }
        }

        //如果有cookie,则打印cookie的时间,并更新cookie存储时间
        if(value!=null){
            pw.write("<h1>欢迎回来，您上次访问时间是"+value+"</h1>");
        }else {
            //没有cookie,则设置cookie
            pw.write("<h1>您好，欢迎首次访问!</h1>");
            Cookie cookie = new Cookie("lastTime",time_value);
            //设置cookie存活时间
            cookie.setMaxAge(60*60*24*30);//一个月
            response.addCookie(cookie);
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
