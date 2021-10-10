<%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-07
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%--添加信息界面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
    <form action="/info" method="post">
        编号:<input type="text" name="id" /><br/>
        姓名:<input type="text" name="name"/><br/>
        分数:<input type="text" name="score"/><br/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
