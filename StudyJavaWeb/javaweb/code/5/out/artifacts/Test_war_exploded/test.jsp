<%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-02
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>

<%-- Test.jsp, 该jsp是最终响应给客户端的页面 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Test</h1>
    <table>
        <tr>
            <th>id</th>
            <th>姓名</th>
        </tr>
        <%--通过getAttribute() 方法获取 index.jsp 转发后的请求--%>
        <tr>
            <td>
                <%=request.getParameter("id")%>
            </td>
            <td><%=request.getParameter("name")%></td>
        </tr>
    </table>
</body>
</html>
