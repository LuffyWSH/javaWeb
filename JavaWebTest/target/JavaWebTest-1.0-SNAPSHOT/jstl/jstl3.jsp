<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: wushuhong
  Date: 2023/4/7
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>foreach</title>
</head>
<body>
<%
    ArrayList<String> al= new ArrayList<>();
    al.add("a");
    al.add("b");
    al.add("c");
    al.add("d");
    al.add("e");
    al.add("f");
    al.add("g");
    al.add("h");
    request.setAttribute("list",al);
%>


<%--循环--%>
<c:forEach begin="1" end="10" var="i" step="1">
    ${i}<br>
</c:forEach>


<%--遍历--%>
<c:forEach items="${list}" var="list_al" varStatus="s">
    ${s.index}
    ${s.count}
    ${list_al}<br>

</c:forEach>
</body>
</html>
