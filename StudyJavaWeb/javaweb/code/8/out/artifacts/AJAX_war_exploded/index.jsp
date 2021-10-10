<%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-08
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>AJAX</title>

</head>
<body>
用户名:<input id="name" type="text" name="name"/><br>
密码: <input id="password" type="password" name="password"/><br>
<input id="register" type="button" value="注册" />

<script type="text/javascript" src="js/jquery_3_6_0.js"></script>
<script type="text/javascript">
  let $name = $("#name");

  $name.blur(function () {
    $.ajax({
      url:"/check",
      type:"post",
      data:"name="+$name.val(),
      dataType:"text",
      success:function (data) {
        console.log("1");

        if(data === "该用户名已被注册!") {
          console.log("hello");
          $name.after("<span id='mark' style='color: red;'>" + data + "</span>");
        } else {
          $name.after("<span id='mark' style='color: lightgreen;'>" + data + "</span>");
        }

        console.log("2");
      }
    })
  });

  $name.focus(function () {
    let $mark = $("#mark");
    if($mark) {
      $mark.remove();
    }
  });

  let $register = $("#register");
  $register.click(function () {
    let $mark = $("#mark");
    let $password = $("#password");
    if($mark.val() === "该用户名已被注册!" || !($name.val()) || !($password.val())) {
    } else {
      $.ajax({
        url:"/check",
        type: "get",
        data:"name=" + $name.val() + "&password=" + $password.val(),
        dataType: "text",
        success:function (data) {
          if(data === "注册失败") {
            $register.before("<span style='color: red;'>" + data + "</span><br/>");
          } else{
            window.location.href = "/welcome.jsp?name="+data;
          }
        }
      })
    }
  })
</script>
</body>
</html>
