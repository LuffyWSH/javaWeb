<%--
  Created by IntelliJ IDEA.
  User: wushuhong
  Date: 2023/4/7
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="true" %>
<html>
<head>
    <title>让el表达式不生效</title>
</head>
<body>
<%--法一：在page中配置isELIgnored="true"--%>
${1>2}
</body>
</html>
