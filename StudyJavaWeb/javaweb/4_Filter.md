# Filter

## 1. 功能

1. 拦截==传入的请求== 和 ==传出的响应== 
2. 修改或以某种方式处理正在客户端和服务器之间交换的数据流

## 2. 使用

实现Filter接口, 并配置虚拟路径即可.

其中可以只实现`doFilter` 方法, `init` 方法 和 `destory` 方法已经使用`default` 关键字在接口中实现了

`default` 关键字是java8新特性, 可以在接口中实现方法

### 2.1 在web.xml中配置

```xml
<filter>
 <filter-name>User</filter-name>
 <filter-class>indi.guxiyuesi.User</filter-class>
</filter>
<filter-mapping>
 <filter-name>User</filter-name>
 <url-pattern>/login</url-pattern>
 <url-pattern>/test</url-pattern>
</filter-mapping>
```

和`Servlet` 配置方法基本一致, 但是可以有多个 `<url-pattern>` , 因为==一个== `Filter` 可以为 ==多个== `Servlet` 服务

### 2.2 使用注解配置

```java
//注解中的内容就是Filter服务的Servlet的虚拟路径
@WebFilter("/info")
public class UsersFilter implements Filter {
}
```

### 2.3 Filter功能的实现

在`doFilter` 方法中处理业务逻辑

```java
@WebFilter("/info")
public class UsersFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)servletRequest;
        httpRequest.setCharacterEncoding("UTF-8");
        String name = httpRequest.getParameter("name");
        if(name != null) {
            name = name.replace("敏感词", "***");
            httpRequest.setAttribute("name", name);
        }

        //必须有, 否则请求/响应无法向后传递, 一直停留在过滤器中
        filterChain.doFilter(httpRequest, servletResponse);
    }
}
```

### 2.4 多个Filter 执行的顺序

1. 在`web.xml` 中, 按配置的先后顺序执行
2. 使用==注解== 配置时, 顺序不定



## 3. Filter的生命周期

1. ==Tomcat启动时== , 通过反射机制调用Filter的无参构造函数==创建实例对象== , 同时调用 ==init== 方法实现初始化
2. `doFilter` 方法可以被调用多次
3. ==Tomcat== 服务关闭时, 调用 `destroy` 方法==销毁Filter对象==  



## 4. Filter的应用

1. 处理中文乱码
2. 屏蔽敏感词
3. 控制资源访问权限

```java
//定义用户类
public class User {
    private String name;
    private int id;
    private int score;

    public User(String name, int id, int score) {
        this.name = name;
        this.id = id;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", score=" + score +
                '}';
    }
}
```

```java
//定义拦截器并配置拦截器
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/info")
public class UsersFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)servletRequest;
        httpRequest.setCharacterEncoding("UTF-8");
        String name = httpRequest.getParameter("name");
        if(name != null) {
            name = name.replace("敏感词", "***");
            httpRequest.setAttribute("name", name);
        }

        filterChain.doFilter(httpRequest, servletResponse);
    }
}

```

````java
//定义Servlet
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/info")
public class UserServlet extends HttpServlet {
    Map<Integer, User> users;

    public UserServlet() {
        this.users = new HashMap<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        users.put(1, new User("张三", 1, 66));
        users.put(2, new User("李四", 2, 77));
        users.put(3, new User("王五", 3, 88));
        req.setAttribute("users", users);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = (String)req.getAttribute("name");
        int id = Integer.parseInt(req.getParameter("id"));
        int score = Integer.parseInt(req.getParameter("score"));
        users.put(id, new User(name, id, score));
        req.setAttribute("users", users);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}

````

```jsp
<%--添加信息界面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
    <form action="/info" method="post">
        编号:<input type="text" name="id" /><br/>
        姓名:<input type="text" name="name"/><br/>
        分数:<input type="text" name="score"/><br/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
```

```jsp
<%--显示信息界面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>show</title>
  </head>
  <body>
    <h3>信息</h3>
    <table>
      <tr>
        <th>编号</th>
        <th>年龄</th>
        <th>分数</th>
      </tr>
      <c:forEach var="user" items="${users}">
        <tr>
          <td>${user.value.id}</td>
          <td>${user.value.name}</td>
          <td>${user.value.score}</td>
        </tr>
      </c:forEach>
    </table><br/>
    <a href="add.jsp">添加</a>
  </body>
</html>

```





# 文件上传下载

## 1. 文件上传

+ JSP

  1. ==input== 中的`type` 选择 `file` 添加上传的文件
  2. ==form== 表单的 `method` 设置为 `post` ; `get` 有长度限制, 一半来说文件上传都会超出限制
  3. ==form== 表单的 `enctype` 设置为 `multipart/form-data`, 以二进制的形式传输数据
     `enctype=multipart/form-data` 表示提交的数据, 以==多段== 的形式(每一个表单项是一个数据段)进行拼接, 然后以==二进制流== 的形式发送给服务器

+ Servlet

  在Servlet中编写后端代码

  ```java
  //上传文件保存到服务器中的底层原理
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //读取从客户端来的文件
      InputStream inputStream = req.getInputStream();
      //读取时防止乱码: InputStream 转为 Reader时指定编码格式为 UTF-8
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
      //通过输出流写到服务器端
      //获取将要写入的文件的绝对路径, 使用Context提供的方法来获取
      //file文件夹在out文件夹下,而不是在web或src文件夹下
      String path = req.getServletContext().getRealPath("file/copy.txt");
      OutputStream outputStream = new FileOutputStream(path);
      BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
      String str = "";
      while ((str=bufferedReader.readLine()) != null) {
          bufferedWriter.write(str + "\n");
      }
      //关闭输入输出流
      bufferedReader.close();
      inputStream.close();
      bufferedWriter.close();
      outputStream.close();
  }
  ```

  

## 1.1 上传时的HTTP协议

![image-20211007225442938](https://gitee.com/four_four/picgo/raw/master/img/20211007225450.png) 



## 1.2 常用类介绍

1. `FileItem` 类, 表示每一个表单项
2. `ServletFileUpload` 类, 用于解析上传的数据
   1. `boolean ServletFileUpload.isMultipartContent(HttpServletRequest req);` 
      判断当前上传的数据格式是否是多段的格式
      如果不是, 不能解析
   2. `publicList<FileItem> parseRequest(HttpServletRequest request)` 
      解析上传的数据
   3. `boolean FileItem.isFormField()` 
      判断是普通的表单项还是上传的文件类型
   4. `String FileItem.getFieldName()` 
      获取表单项的 ==name== 属性值
   5. `String FileItem.getString()` 
      获取当前表单项的值
   6. `String FileItem.getName()` 
      获取上传的文件名
   7. `void FileItem.write(file)` 
      将上传的文件写道 参数 ==file== 所指向的硬盘位置

```java
//文件上传实例   使用ServletFileUpdate类
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //判断是否是多段数据
    if(ServletFileUpload.isMultipartContent(req)) {
        //是多段数据
        //创建FileItemFactory的工厂实现类
        FileItemFactory fileItemFactory = new DiskFileItemFactory();
        //创建用于解析上传数据的工具类ServletFileUpload的实例对象
        ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

        try {
            //解析上传的数据
            List<FileItem> fileItems = servletFileUpload.parseRequest(req);

            //对于多个表单项, 逐个判断是否是文件
            for (FileItem fileItem:fileItems) {
                if(fileItem.isFormField()) {
                    //是普通表单项
                    System.out.println("表单项属性名: " + fileItem.getFieldName());
                    System.out.println("表单内容: " + fileItem.getString("UTF-8"));
                }
                else {
                    //是上传的文件
                    System.out.println("表单项属性名: " + fileItem.getFieldName());
                    System.out.println("上传的文件名: " + fileItem.getName());
                    //将上传的文件保存到硬盘中
                    String path = req.getServletContext().getRealPath("file/" + fileItem.getName());
                    fileItem.write(new File(path));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## 2. 文件下载

+ 文件下载的步骤
  1. 告诉客户端实际返回的内容的内容类型
     `resp.setContentType("application/x-msdownload")`
  2. 设置以什么方式下载以及下载之后的文件名
     `resp.setHeader("Content-Disposition", "attachment; filename=FileName.txt")` 
  3. 获取文件在服务器中的路径
     `String path = req.getServletContext().getRealPath(file)` 
  4. 获取输入输出流
     输入流：`InputStream is = new FileInputStream(path)` 
     输出流: `OutputStream os = resp.getOutputStream()` 
  5. 将输入流的内容写入到响应中
     `IOUtils.copy(InputStream, OutputStream)`

```java
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //设置响应头, 调用下载器
    resp.setContentType("application/x-msdownload");
    String fileName = "test.html";
    resp.setHeader("Content-Disposition", "attachment;filename:"+fileName);
    //获取存储路径
    String path = req.getServletContext().getRealPath("/file/"+fileName);
    //输入输出流
    InputStream inputStream = new FileInputStream(path);
    OutputStream outputStream = resp.getOutputStream();
    //直接使用IOUtils工具类将输入流的内容通过输出流写入到响应中
    IOUtils.copy(inputStream, outputStream);
}
```





# AJAX

Asynchronous JavaScript And XML：异步的 JavaScript 和 XML AJAX 不是新的编程，指的是⼀种交互⽅式，异步加载，客户端和服务器的数据交互更新在局部⻚⾯的 技术，不需要刷新整个⻚⾯（局部刷新） 优点： 

1. 局部刷新，效率更⾼ 
2. ⽤户体验更好

## 1. AJAX原理

![image-20211010142546479](https://gitee.com/four_four/picgo/raw/master/img/20211010142546.png) 

### 1.1 JSON

JavaScript Object Notation, 一种轻量级的数据交换格式, 用于服务端和客户端传递对象类型的数据

### 1.2 传统的数据交互 vs AJAX

1. ==客户端请求方式== :
   + 传统的请求方式是==同步请求== (`form`, `a`), 需要刷新整个页面
   + AJAX发送==异步请求== , 可以不用刷新整个页面

2. ==服务器的响应方式== :
   + 传统方式响应一个完整的`JSP`页面
   + AJAX响应需要的数据
3. ==客户端处理的处理方式== :
   + 传统方式需要等到服务器完成响应并重新加载整个页面之后, 用户才能进行后续操作
   + AJAX==动态更新== 页面中的局部内容 , 不影响用户的其他操作



## 2. 基于JQuery的AJAX语法

`$.ajax({属性})` 

### 2.1 常用的属性参数

1. `url` : 请求的后端服务地址
2. `type` : ==请求方式== , 默认为`get` 
3. `data` : ==请求参数== , 相当于`url` 中 `?` 后面的部分
4. `dataType` : 服务器==返回== 的数据类型
5. `success` : 请求成功的回调函数
6. `error` : 请求失败的回调函数
7. `complete` : 请求成功的回调函数 (一定会执行)

## 3. 使用AJAX模拟注册界面

应用AJAX的地方: 当输入用户名后, 点击其他地方, 可以动态的显示该用户名是否可用 

```java
//后端程序, 判断用户名是否可用及点击注册按钮后判断是否注册成功
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/check")
public class MyServlet extends HttpServlet {
    //使用names模拟数据库中已经存在的名字
    private Set<String> names;

    public MyServlet() {
        names = new HashSet<>();
        names.add("张三");
        names.add("李四");
        names.add("王五");
    }

    //判断用户名是否可用
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        if(names.contains(name)) {
            resp.getWriter().write("该用户名已被注册!");
        } else {
            resp.getWriter().write("该用户名可用");
        }
    }

    //判断是否可以注册成功
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if(names.contains(names)) {
            resp.getWriter().write("注册失败");
        } else {
            names.add(name);
            resp.getWriter().write(name);
        }
    }
}
```

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>AJAX</title>
</head>
<body>
<!-- 模拟注册界面 -->
用户名:<input id="name" type="text" name="name"/><br>
密码: <input id="password" type="password" name="password"/><br>
<input id="register" type="button" value="注册" />

<!-- js代码, 引入JQuery -->
<script type="text/javascript" src="js/jquery_3_6_0.js"></script>
<script type="text/javascript">
  //获取id为name的JQuery对象
  let $name = $("#name");

  // $name失去焦点时的事件
  $name.blur(function () {
    //调用ajax
    $.ajax({
      url:"/check",				//后端处理程序地址
      type:"post",				//提交的方式, 即使使用post方式, 后端的Servlet程序也必须有 doGet 方法
      data:"name="+$name.val(), //提交的参数
      dataType:"text",			//返回的数据类型
      //请求成功后的回调函数
      success:function (data) {
        //将返回的数据写入界面
        if(data === "该用户名已被注册!") {
          $name.after("<span id='mark' style='color: red;'>" + data + "</span>");
        } else {
          $name.after("<span id='mark' style='color: lightgreen;'>" + data + "</span>");
        }
      }
    })
  });
    
  //$name获得光标时的事件
  //去掉输入框后的数据(即该用户名是否可用)
  $name.focus(function () {
    let $mark = $("#mark");
    if($mark) {
      $mark.remove();
    }
  });

  //点击注册按钮时的事件
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
            //跳转到新的页面的方法
            //也可以建议一个隐藏的form, 然后通过form跳转
            window.location.href = "/welcome.jsp?name="+data;
          }
        }
      })
    }
  })
</script>
</body>
</html>
```

```jsp
<%-- 注册成功时的界面 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    注册成功!<%= request.getParameter("name") %>
</body>
</html>
```

