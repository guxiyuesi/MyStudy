<%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-03
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="/login/check" method="get">
        <table>
            <tr>
                <tb>用户名:</tb>
                <tb><input type="text" name="user"/></tb>
            </tr>
            <tr>
                <tb>密码:</tb>
                <tb><input type="password" name="password"/></tb>
            </tr>
            <tr>
                <tb><input type="submit" value="登录"/></tb>
                <tb><input type="reset" value="撤销"></tb>
            </tr>
        </table>
    </form>
</body>
</html>
