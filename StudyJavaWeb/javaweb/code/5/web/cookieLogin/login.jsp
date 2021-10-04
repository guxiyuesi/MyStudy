
<%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-03
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%-- /cookieLogin/login.jsp  登录页面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>登录</h1>
    <form action="/cookieLogin/check" method="post">
        <table>
            <tr>
                <tb>用户名:</tb>
                <tb><input type="text" name="user"/></tb>
            </tr><br/>

            <tr>
                <tb>密码:</tb>
                <tb><input type="password" name="password"/></tb>
            </tr><br/>

            <tr>
                <tb><input type="submit" value="登录"/></tb>
                <tb><input type="reset" name="撤销"/></tb>
            </tr><br/>
        </table>
    </form>
</body>
</html>
