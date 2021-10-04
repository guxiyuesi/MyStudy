<%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-03
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%-- /cookieLogin/Welcome.jsp  登录成功页面 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    欢迎回来!
    <%
        Cookie[] cookies = request.getCookies();
        String user = null;
        for (Cookie cookie:cookies) {
            if(cookie.getName().equals("user")) {
                user = cookie.getValue();
                break;
            }
        }
    %>
    <%= user %>
    <a href="/cookieLogin/exit">退出登录</a>
</body>
</html>
