<%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-03
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL1</title>
</head>
<body>
    <%
        pageContext.setAttribute("name", "pageContext");
        request.setAttribute("name", "request");
        session.setAttribute("name", "session");
        application.setAttribute("name", "application");
    %>

    ${name}
    ${sessionScope.name}
</body>
</html>
