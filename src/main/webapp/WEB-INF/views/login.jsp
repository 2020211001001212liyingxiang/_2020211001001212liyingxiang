<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/4/12
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<%
    if (request.getAttribute("message")!=null){
        //error
        out.println(request.getAttribute("message"));
    }
%>
<form action="<%=request.getContextPath()%>/login" method="post">
    UserName:<input type="text" name="username"> <br>
    Password:<input type="password" name="password"> <br>
    <input type="submit" value="Login">
</form>
</body>
</html>

<%@include file="footer.jsp"%>