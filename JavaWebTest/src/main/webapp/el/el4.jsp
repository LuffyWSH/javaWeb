<%--
  Created by IntelliJ IDEA.
  User: wushuhong
  Date: 2023/4/7
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取值</title>
</head>
<body>

<%
    //定义一次请求共享域对象
    request.setAttribute("name","zhangsan");
%>
<%
    //定义一次会话共享域域对象
    HttpSession session1 = request.getSession();
    session1.setAttribute("password","123456");
%>
<%
    //定义服务器上下文共享域域对象
    ServletContext servletContext = request.getServletContext();
    servletContext.setAttribute("love","music");
%>

<%--法一--%>
${requestScope.name}
${sessionScope.password}
${applicationScope.love}

<%--法二--%>
${name}
${password}
${love}
</body>
</html>
