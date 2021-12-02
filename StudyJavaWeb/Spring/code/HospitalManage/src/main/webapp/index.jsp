<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/login.css" charset="GBK"/>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery_3_6_0.js"></script>


</head>

<body>
<div class="loginAll">
    <div class="loginTitle">
        <h1>登录</h1>
    </div>
        <div class="loginInput">
            <input name="account" class="loginInputValue" id="account" type="text" placeholder="请输入账号"><br/>
            <input name="password" class="loginInputValue" id="password" type="password" placeholder="请输入密码"><br/>
            <div id="loginRadio">
                <div ><label>角色:&nbsp</label></div>
                <div >
                    <input  type="radio" name="radio" value="doctor" checked>
                    <label>医生</label><br>
                    <input type="radio" name="radio" value="admin">
                    <label>管理员</label><br>
                    <input type="radio" name="radio" value="patient">
                    <label>病人</label><br>
                </div>
            </div>
            <div id="login">
                <input id="loginButton" value="登录" type="button">
            </div>

        </div>
    <div id="signUpDiv">
        <a  href="signUp.jsp">注册</a>
    </div>
</div>

<script type="text/javascript" src="<%=request.getContextPath() %>/js/login.js"></script>
</body>

</html>



