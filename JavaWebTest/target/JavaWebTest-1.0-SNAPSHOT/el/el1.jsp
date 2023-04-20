<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: wushuhong
  Date: 2023/4/6
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>简单算术运算</title>
</head>
<body>
<%
    ArrayList<String> al = new ArrayList<>();
    al.add("abc");
    request.setAttribute("list",al);
%>

<%--el里面放的是表达式，一些简单运算--%>
${10+4}
${10-4}
${10/4}
${10%4}
${10*4}
${1>2 && 1>0}
${1>2 || 1>0}
${1!=0}

<%--空运算符： empty 用于判断字符串、集合、数组对象是否为null或者长度是否为0--%>
${empty list}
</body>
</html>
