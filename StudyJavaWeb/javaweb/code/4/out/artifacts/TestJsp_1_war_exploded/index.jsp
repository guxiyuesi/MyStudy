<%@ page import="java.util.List" %>
<%@ page import="indi.guxiyuesi.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-01
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>用户信息:</h1>
  <table border="1px">
    <tr>
      <th>姓名</th>
      <th>年龄</th>
    </tr>

    <%
      List<User> list = new ArrayList<>();
      list.add(new User("张三", 24));
      list.add(new User("李四", 21));
      list.add(new User("王五", 22));
    %>


    <%
      for (User user:list) {
    %>
    <tr>
      <td> <%= user.getName() %> </td>
      <td> <%= user.getAge() %> </td>
    </tr>
    <%
      }
    %>

  </table>

  </body>
</html>
