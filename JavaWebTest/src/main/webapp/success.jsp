<%--
  Created by IntelliJ IDEA.
  User: wushuhong
  Date: 2023/4/5
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<h1><%= request.getSession().getAttribute("user")%>欢迎您</h1>

</body>
</html>
