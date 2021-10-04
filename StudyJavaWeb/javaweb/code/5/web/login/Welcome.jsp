<%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-03
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
欢迎回来!<%=session.getAttribute("user")%>
<a href="/login/Exit">退出登录</a>
</body>
</html>
