<%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-04
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
    <form action="/index" method="post">
        编号:<input type="text" name="id" value="${user.id}" readonly/><br/>
        姓名:<input type="text" name="name" value="${user.name}" /><br/>
        年龄:<input type="text" name="age" value="${user.age}"/><br/>
        <input type="submit" value="修改">
    </form>
</body>
</html>
