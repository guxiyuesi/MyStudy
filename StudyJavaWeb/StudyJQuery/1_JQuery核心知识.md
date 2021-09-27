# JQuery

## 1. 入门

### 1.1 什么是JQuery

JavaScript的第三方库

### 1.2 如何使用JQuery

````html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Title</title>
    </head>

    <body>
        <button id="bn">hello world</button>
    </body> 

    <!--原生java操纵DOM元素-->
    <!-- <script type="text/javascript">
        let bn = document.getElementById("bn");
        alert(bn.innerText);
    </script> -->

    <!--使用JQuery操纵DOM元素-->
    <script type="text/javascript" src="../JQuery/jquery_3_6_0.js"></script>
    <script type="text/javascript">
        $(function(){alert("test")});       //相当于window.onload = function(){alert("test")};
        let $bn = $("#bn");                  //相当于let bn = document.getElementById("bn");
        $bn.click(function(){				//绑定单击事件
            alert("单击事件");
        })
    </script>
</html>
````



###1.3 $函数介绍

==$== 中的重要函数, 其本质是就是一个JS中的函数, 使用方法有以下几种:

1. 传入的是==函数== 时, `\$` 相当于 `window.onload` 
2. 传入的是==HTML字符串== 时, 会自动创建html标签对象
3. 传入的是==选择器字符串== 时, 会自动创建选择器标签对象
4. 传入的是==DOM对象== 时, 会自动创建JQuery对象  

```JavaScript
<!DOCTYPE html>
<html>
    <!--html代码-->
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>about$</title>
    </head>

    <body>
        <span>
            <div id="div1">span-div1</div>
            <div id="div2">span-div2</div>
        </span>
    </body>

	<!--jquery代码-->
    <script type="text/javascript" src="../JQuery/jquery_3_6_0.js"></script>
    <script type="text/javascript">
        //传入的参数是 函数
        $(function() {
            alert("test");
        })

        //传入的参数是 HTML字符串
        $('<span>' +
            ' <div id="div3">span-div3</div>' +
            '<div id="div4">span-div4</div>' +
            '</span>').appendTo("body");

        //传入的参数是 选择器字符串
        $("#div1");

        //传入的参数是 DOM对象
        let $div1 = $(document.getElementById(div1));
    </script>
</html>
```

