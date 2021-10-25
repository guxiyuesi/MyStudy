<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<form action="/myTest/pojo">
    <table>
        <tr>
            <td>姓名:</td>
            <td><input type="text" name="name" /></td>
        </tr>

        <tr>
            <td>编号:</td>
            <td><input type="text" name="id" /></td>
        </tr>

        <tr>
            <td>地址:</td>
            <td><input type="text" name="address.name" /></td>
        </tr>
        <tr>
            <td>
            <input type="submit" value="提交" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>
