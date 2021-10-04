<%@ page import="indi.guxiyuesi.User" %><%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-03
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL2</title>
</head>
<body>
    <%
        User user = new User("张三", 15, 88);
        request.setAttribute("person", user);
    %>
    <table>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>年龄</td>
        </tr><br/>
        <tr>
            <td>${person.id}</td>
            <td>${person.name}</td>
            <td>${person.score}</td>
        </tr>
    </table><br/>
    人物综合信息:${person}<br/>
    人物综合信息:<%=request.getAttribute("person").toString()%>
</body>
</html>
