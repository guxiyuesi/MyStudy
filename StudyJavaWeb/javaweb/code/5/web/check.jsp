<%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-02
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        if(user.equals("admin") && password.equals("admin")) {
            request.setAttribute("name", user);
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    %>
</body>
</html>
