<%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-07
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%--显示信息界面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>show</title>
  </head>
  <body>
    <h3>信息</h3>
    <table>
      <tr>
        <th>编号</th>
        <th>年龄</th>
        <th>分数</th>
      </tr>
      <c:forEach var="user" items="${users}">
        <tr>
          <td>${user.value.id}</td>
          <td>${user.value.name}</td>
          <td>${user.value.score}</td>
        </tr>
      </c:forEach>
    </table><br/>
    <a href="add.jsp">添加</a>
  </body>
</html>
