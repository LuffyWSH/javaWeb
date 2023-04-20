<%@ page import="com.wsh.domain.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: wushuhong
  Date: 2023/4/7
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>练习</title>
</head>
<%--需求：在request域中有一个存有User对象的List集合。需要使用jstl+el将list集合数据展示到jsp页面的表格table中--%>
<body>
<%
    User user1 = new User("zs", "123");
    User user2 = new User("ls", "123");
    User user3 = new User("ww", "123");
    ArrayList<User> al = new ArrayList<>();
    al.add(user1);
    al.add(user2);
    al.add(user3);
    request.setAttribute("list",al);
%>

<c:forEach items="${list}" var="li">
    ${li.name}:${li.password}<br>
</c:forEach>

</body>
</html>
