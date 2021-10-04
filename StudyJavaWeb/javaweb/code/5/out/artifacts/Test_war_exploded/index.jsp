<%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-02
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h1>Index</h1>
    <%
      request.setCharacterEncoding("UTF-8");
      int id = Integer.parseInt(request.getParameter("id"));
      request.setAttribute("idInt", id);
      response.sendRedirect("test.jsp");
    %>

  </body>
</html>
