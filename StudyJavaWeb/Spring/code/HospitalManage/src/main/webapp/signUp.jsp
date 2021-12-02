<%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-11-22
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/signUp.css">
    <script type="text/javascript" src="js/jquery_3_6_0.js"></script>
</head>

<body>
<div id="signUpAll">
    <h1 id="signUpTitle">注册</h1>
        <div >
            <input class="signUpInputValue" type="text" name="account" id="account" placeholder="请输入账号">
        </div>
        <div >
            <input class="signUpInputValue" type="password" name="password" id="password" placeholder="请输入密码">
        </div>

        <div id="signUp">
            <input id="signUpButton" type="button" value="注册">
        </div>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/signUp.js"></script>
</body>
</html>