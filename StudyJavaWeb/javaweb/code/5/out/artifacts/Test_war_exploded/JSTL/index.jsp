<%@ page import="indi.guxiyuesi.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-04
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL</title>
</head>
<body>
    <%
        User user = new User("王二麻子", 21, 4);
        request.setAttribute("user", user);
    %>

<%--    <c:set  target="${user}" property="name" value="abc"></c:set>--%>
<%--    ${requestScope.name}--%>
<%--    ${user.name}--%>
<%--    <c:set var="name" value="hello" scope="request"></c:set>--%>
<%--    <c:out value="${name}" default="未定义"></c:out><br/>--%>
<%--    <c:remove var="name" scope="request"></c:remove>--%>
<%--    <c:out value="${name}" default="未定义"></c:out>--%>
<%--    <c:catch var="error">--%>
<%--        <%--%>
<%--            int i = 10 / 0;--%>
<%--        %>--%>
<%--    </c:catch>--%>
<%--    ${error}--%>

<%--    <%--%>
<%--        int num1 = 1;--%>
<%--        int num2 = 2;--%>
<%--        request.setAttribute("num1", num1);--%>
<%--        request.setAttribute("num2", num2);--%>
<%--    %>--%>
<%--    <c:if test="${num1 > num2}" >true</c:if>--%>
<%--    <c:if test="${num1 <= num2}" >false</c:if>--%>
<%--    <hr/>--%>
<%--    <c:choose>--%>
<%--        <c:when test="${num1 > num2}">true</c:when>--%>
<%--        <c:otherwise>false</c:otherwise>--%>
<%--    </c:choose>--%>
    <%
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        request.setAttribute("list", list);
    %>

    <c:forEach items="${list}" var="str" begin="2" end="8" step="2" varStatus="over">
        ${over.count}-${str}<br/>
    </c:forEach>
</body>
</html>
