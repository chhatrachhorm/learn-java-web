<%--
  Created by IntelliJ IDEA.
  User: chhatrachhorm
  Date: 2/9/18
  Time: 8:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page errorPage="error.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result Page</title>
</head>
<body>
<%
    Integer a = Integer.valueOf(request.getParameter("fnum"));
    Integer b = Integer.valueOf(request.getParameter("snum"));
%>
    <h1>The value is <%= a/b %></h1>
</body>
</html>
