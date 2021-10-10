<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-04
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("date", new Date());
    %>
    <fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate><br/>
    <fmt:formatNumber value="432.532" maxIntegerDigits="2" maxFractionDigits="1"></fmt:formatNumber>
</body>
</html>
