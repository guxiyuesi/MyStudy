let $signUpButton = $("#signUpButton");

$signUpButton.on('click', function () {
    let $account = $("#account");
    let $password = $("#password");
    $.ajax( {
        url:"/enterSystem/signUp",
        type:"post",
        data:"account=" + $account.val() +
            "&password=" + $password.val() +
            "&radio=patient",
        dataType:"text",
        success:function (data) {

            if (data === "sign up failed") {
                let $mark = $("#mark");
                if ($mark.val() === undefined) {
                    $signUpButton.before("<span id='mark' style='color: red;'>注册失败 </span><br/>");
                }
            } else {
                window.location.href = "index.jsp";
            }
        }
    })
});