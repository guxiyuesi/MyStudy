let $loginButton = $("#loginButton");
$loginButton.click(function () {
    let $account = $("#account");
    let $password = $("#password");
    let $radio = $("input[name=radio]:checked");
    $.ajax({
        url:"/enterSystem/login",
        type:"post",
        data:"account=" + $account.val() +
             "&password=" + $password.val() +
             "&radio=" + $radio.val(),
        dataType:"text",
        success:function (data) {
            if (data === "login false") {
                console.log(data);
                let $mark = $("#mark");
                if ($mark.val() === undefined) {
                    $loginButton.before("<span id='mark' style='color: red;'>登录失败 </span><br/>");
                    $("#signUpDiv").attr("top", "-20px");
                }
            }else {
                //跳转到新页面
                window.location.href = "adminPattern.jsp";
            }
        }
    })
});