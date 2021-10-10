<%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-04
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
    <form action="/index" method="post">
        编号:<input type="text" name="id" /><br/>
        姓名:<input type="text" name="name" /><br/>
        年龄:<input type="text" name="age" /><br/>
        <input type="submit" value="添加">
    </form>
</body>
</html>
