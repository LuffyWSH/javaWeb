<%--
  Created by IntelliJ IDEA.
  User: wushuhong
  Date: 2023/4/7
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    1. <%  代码 %>：定义的java代码，在service方法中。service方法中可以定义什么，该脚本中就可以定义什么。
    2. <%! 代码 %>：定义的java代码，在jsp转换后的java类的成员位置。
    3. <%= 代码 %>：定义的java代码，会输出到页面上。输出语句中可以定义什么，该脚本中就可以定义什么。
--%>
<%! int i=3;%>
<% int i=4;%>
<%= i%>
</body>
</html>
