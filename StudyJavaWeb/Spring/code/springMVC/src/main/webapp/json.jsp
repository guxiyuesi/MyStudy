<%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-26
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="webjars/jquery/3.6.0/jquery.js"></script>
    <script type="text/javascript">
        let user = {
            id : 1,
            name : mary
        };
        $.ajax({
            url : "/jsonType/json",
            data : JSON.stringify(user),

        })
    </script>
</head>
<body>
</body>
</html>
