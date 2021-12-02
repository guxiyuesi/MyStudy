<%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-26
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/myHandler/myMap" method="post">
        <!-- 这里的a, b都是map里的key -->
        用户1 编号 : <input type="text" name="users['a'].id"/><br/>
        用户1 姓名 : <input type="text" name="users['a'].name"/><br/>
        用户2 编号 : <input type="text" name="users['b'].id"/><br/>
        用户2 姓名 : <input type="text" name="users['b'].name"/><br/>
        <input type="submit" value="提交"/>
    </form>

</body>
</html>
