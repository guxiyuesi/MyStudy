<%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-02
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <h2>登录:</h2>
    <form action="check.jsp" method="get">
        用户名:<input type="text" name="user"/>
        密码  :<input type="password" name="password"/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
