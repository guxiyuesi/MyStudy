<%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-26
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/myHandler/myList" method="post">
        用户1 编号 : <input type="text" name="users[0].id"/><br/>
        用户1 姓名 : <input type="text" name="users[0].name"/><br/>
        用户2 编号 : <input type="text" name="users[1].id"/><br/>
        用户2 姓名 : <input type="text" name="users[1].name"/><br/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
