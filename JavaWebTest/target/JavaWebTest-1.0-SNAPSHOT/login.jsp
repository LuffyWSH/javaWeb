<%--
  Created by IntelliJ IDEA.
  User: wushuhong
  Date: 2023/4/5
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script>
        window.onload=function (){
            //获得按钮
            var button = document.getElementById("change");
            //给按钮绑定事件
            button.onclick=fun;
            //定义事件
            function fun(){
                //获得图片
                var image = document.getElementById("imag");
                //获得时间戳
                var date = new Date();
                var time = date.getTime();
                //改变图片路径（拼接时间戳字符串）
                image.setAttribute("src","/JavaWebTest/Servlet_Response4?"+time)
            }
        }
    </script>
    <style>
        div{
            color: red;
        }
    </style>
</head>
<body>
<br>
<br>
<form action="/JavaWebTest/ServletSession4" method="post">
    用户名 <input type="text" name="username" placeholder="请输入用户名"><br>
    密码  <input type="password" name="password" placeholder="请输入密码"><br>
    验证码 <input type="text" name="code"><br>
    <img id="imag" src="/JavaWebTest/Servlet_Response4" alt="验证码">
    <input type="button" id="change" value="点击更换验证码"><br>
    <input type="submit" value="提交">
</form>
<%--<div>
    <%
    String userpw_error =(String) request.getSession().getAttribute("userpw_error");
    String code_error =(String) request.getSession().getAttribute("code_error");
    if(userpw_error!=null){
        response.getWriter().write(userpw_error);
    }else if (code_error!=null){
        response.getWriter().write(code_error);
    }
%>
</div>--%>
<div><%= request.getSession().getAttribute("userpw_error")==null ? "" : request.getSession().getAttribute("userpw_error")%></div>
<div><%= request.getSession().getAttribute("code_error")==null ? "" : request.getSession().getAttribute("code_error")%></div>

</body>
</html>
