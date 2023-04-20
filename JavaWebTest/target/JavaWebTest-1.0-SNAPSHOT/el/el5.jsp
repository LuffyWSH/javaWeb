<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wsh.domain.User" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: wushuhong
  Date: 2023/4/7
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取对象</title>
</head>
<body>
<%--获取对象里的值--%>
<%
    User user = new User("wsh","123456");
    request.setAttribute("user",user);
%>
${user.name}

<%--获list对象里的值--%>
<%
    ArrayList<String> al = new ArrayList<>();
    al.add("abc");
    al.add("def");
    request.setAttribute("list",al);
%>
${list[1]}

<%--获取map集合里的值--%>
<%
    HashMap<String,String> hm =new HashMap<>();
    hm.put("hobby","swim");
    hm.put("love","animal");
    request.setAttribute("map",hm);
%>
${map.hobby}
${map["love"]}
</body>
</html>
