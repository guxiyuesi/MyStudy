<%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-04
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Information</title>
  </head>
  <body>
    <form action="/index" method="get">
      <table>
        <tr>
          <th>编号</th>
          <th>姓名</th>
          <th>年龄</th>
        </tr>

        <c:forEach items="${users}" var="user" >
          <tr>
            <td>${user.value.id}</td>
            <td>${user.value.name}</td>
            <td>${user.value.age}</td>
            <td><a href="/index?method=delete&key=${user.value.id}">删除</a>
                <a href="/index?method=update&key=${user.value.id}">修改</a></td>
          </tr>
        </c:forEach>

      </table><br/>

    </form>
    <a href="/index?method=add">添加</a>
  </body>
</html>
