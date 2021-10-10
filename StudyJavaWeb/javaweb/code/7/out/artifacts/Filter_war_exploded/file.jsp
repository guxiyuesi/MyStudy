<%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-07
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File</title>
</head>
<body>
    <form action="/file" method="post" enctype="multipart/form-data">
        <input name="text" type="text"/><br/>
        <input name="file" type="file"/><br/>
        <input value="提交" type="submit">
    </form>
</body>
</html>
