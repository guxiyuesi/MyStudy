# JSP

## 1. 什么是JSP

JSP本质上就是一个 ==Servlet== , 主要负责与用户交互, 将最终的界面呈现给用户, 可以理解为 ==HTML + CSS + js + java== 的混合文件

当服务器接收到一个后缀是`.jsp`的请求时, 将该请求交给JSP引擎去处理, 每一个JSP页面第一次被访问时, JSP引擎会将它翻译成一个Servlet文件, 由Web容器来调用Servlet来完成响应 

从开发的角度来看, JSP就是在HTML中嵌入java程序

具体的嵌入方式:

1. JSP脚本: 执行java逻辑代码

   ```jsp
   <%
   java代码
   %>
   ```

2. JSP声明: 定义java方法

   ```jsp
   <%!
   java方法
   %>
   ```

3. JSP表达式: 把java对象直接输出到HTML页面中

   ```jsp
   <%= java变量 %>
   ```


```java
// src中的User类
package indi.guxiyuesi;

public class User {
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

```

```jsp
<%-- jsp代码中调用src中的User类, 并将User类中的信息输出到前端 --%>
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
```





## 2. JSP 内置对象

内置对象: JSP已经创建好的对象, 可以直接使用

9个内置对象:

`request` : 表示==一次== 请求, 由 `HttpServletRequest` 类创建的对象

`response` : 表示 ==一次== 响应, 由 `HttpServletResponse` 类创建的对象

`pageContext` : 页面环境, 可以获取页面信息, 来自于`PageContext` 类 

`session` : 表示 ==一次== 会话, ==一次会话== 可以有==很多个== `request` 和 `response` , 由 `HttpSession` 类创建的对象

`application` : 表示当前的web应用的全局对象, 保存所有用户的共享信息, 由 `ServletContext` 类创建的对象

`config` : 当前JSP对应的Servlet的`ServletConfig` 对象, 可以获取当前的Servlet的信息

`out` : 向浏览器输出数据. `JspWriter`类的对象. 

`page` : 当前 JSP 对应的Servlet对象, 来自于 `Servlet` , 同时也是 `this` 

`exception` : 表示 JSP页面发生的异常, 来自于`Exception` 

常用的是: `request`, `response`,  `session` , `application` , `pageContext` 



### 2.1 request常用方法

1. `String getParameter(String key)` 获取客户端传来的参数
2. `void setAttribute(String key, Object value)`  通过键值对的形式来保存数据
3. `Object getAttribute(String key)`  通过key取出value

`getParameter` 方法通常用于 ==服务端接收客户端== 请求时使用的方法

`setAttribute` 和 `getAttrubute` 通常用于一个服务器中不同的JSP之间的请求

客户端的参数 即使转发过后也只能通过 `getParameter`  访问

4. `RequestDispatcher getRequestDispatcher(String path)` 返回一个 `RequestDispatcher` 对象, 该对象的 `forword` 方法用于==请求转发==  
5. `String[] getParameterValues()` 
   当请求有多个参数且参数名相同时, 使用 `getParameterValues` 时只能获取到第一个 value, 但是使用 `getParameterValues` 可以获取到所有的参数
6. `void setCharacterEncoding(String charset)` 指定每个请求的编码

```jsp
<%-- index.jsp, 用来做请求中转 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h1>Index</h1>
     <%-- 获取到参数 id 的 value并转为int类型 --%>
     <%-- 向request写入 idInt=id 的键值对 --%>
     <%-- 将请求转发给test.jsp --%>
      <%
     int id = Integer.parseInt(request.getParameter("id"));
     request.setAttribute("idInt", id);
      request.getRequestDispatcher("test.jsp").forward(request, response);
    %>
  </body>
</html>
```

```jsp
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
            <%
                int id = (Integer) request.getAttribute("idInt");
                String name = request.getParameter("name");
            %>
            <td>
                <%=id%>
            </td>
            <td><%=name%></td>
        </tr>
    </table>
</body>
</html>
```



### 2.2 http请求状态码

200 : 正常

404 : 资源找不到

400 : 请求类型不匹配

500 : java程序出现异常

### 2.3 response常用方法

1. `void sendRedirect(String path)` 重定向, 页面之间的跳转

   请求转发与重定向的区别:

   + 请求转发,是一种==服务器的行为== ，客户端只有 ==一次请求== ，服务器端转发后会==保存请求对象== ，==地址栏中的URL地址不会改变== ，得到响应后服务器端再将响应发给客户端
   + 请求重定向, 是一种客户端行文，从本质上讲等同于两次请求，前一次请求对象不会保存, 客户端的参数也不会保存，地址栏的URL地址会改变。
   + 如果两个页面之间需要通过 request 来传值, 则必须使用转发, 不能使用重定向

![image-20211002171554229](https://gitee.com/four_four/picgo/raw/master/img/20211002171601.png) 



## 3. Session

用户会话

服务器无法识别每一次http请求的出处(不知道来自于哪个终端), 它只会接收到一个请求信号. 所以就存在一个问题: 将用户的响应反送给其他人.

因此必须有一种技术来让服务器知道请求来自哪, 这就是会话技术. 

Session是 ==实现会话的一种具体的方式==

会话: 客户端与服务器之间发生的一系列==连续的请求和响应的过程== , 打开浏览器进行操作到关闭浏览器的过程

会话状态: 指服务器和浏览器在会话过程中产生的状态信息, 借助于会话状态, 服务器能够把属于同义词会话的一系列请求和响应关联起来

+ 实现会话的方式:
  + session
  + cookie

Session的常用方法:

+ `String getId()`         获取sessionID
+ `void setMaxInactiveInterval(int interval)` 设置session的失效时间, 单位为秒
+ `int getMaxInactiveInterval()`    获取当前session的失效时间
+ `void invalidate()`      设置session立即失效
+ `viod setAttribute(String key, Object value)`       通过键值对的形式来存储数据
+ `Object getAttribute(String key)` 通过键获取到对应的数据
+ `void removeAttribute(String key)` 移除对应的键值对

### Session与Cookie的区别

1. Cookie

   1. 浏览器第一次访问请求到服务器端时, 服务器创建一个Cookie, 该Cookie包含用户的信息, 然后将Cookie发送给客户端
   2. 客户端再次访问服务器端时会携带服务器端创建的Cookie.
   3. 服务器通过Cookie携带的数据来区分不同的用户
   4. 即 ==Cookie由服务器创建, 保存在客户端, 每次访问时都要携带Cookie; 保存的对象是字符串类型; 可以长期保存在客户端中; 保存不重要的信息== 

2. Session

   1. 客户端第一次访问服务器时, 服务器会创建一个Session和一个特殊的Cookie(key=JSESSIONID, value=session的ID), 然后将该Cookie发送给客户端
   2. 以后浏览器访问服务端时, 都携带这种特殊的Cookie; 服务器通过获取到的Cookie的value(也就是session的ID, 简写为sessionId)来区分不同的用户
      + ==当name = JSESSIONID不存在时==(关闭 或更换浏览器), 返回1重新创建Cookie
      + ==当name = JSESSIONID存在时==,  根据value = sessionId寻找Session对象
      + ==当value=sessionId不存在时== (Session过期), 返回1重新创建Cookie
      + ==当value=sessionId存在时== , 返回Session对象
   3. 即 ==Session保存在服务器中, 保存的数据是Object类型; 随着会话的结束而结束; 保存重要信息==

   存取信息上:

   + Session:
     + `void setAttribute(String key, Object value)` 存
     + `Object getAttribute(String key)`   取
     + 声明周期随服务器的关闭而销毁
     + 手动销毁生命周期: `session.invalidate()`
   + Cookie:
     + 存 `response.addCookie(new Cookie(String key, String value))`   
     + 取 通过遍历Cookie取
     + 声明周期: 默认关闭浏览器时销毁, 设置有效时间后随有效时间的结束而结束
     + 手动销毁生命周期: `cookie.setMaxAge(0)` 

### 使用Session保存登录信息实例

````jsp
<%-- login.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="/login/check" method="get">
        <table>
            <tr>
                <tb>用户名:</tb>
                <tb><input type="text" name="user"/></tb>
            </tr>
            <tr>
                <tb>密码:</tb>
                <tb><input type="password" name="password"/></tb>
            </tr>
            <tr>
                <tb><input type="submit" value="登录"/></tb>
                <tb><input type="reset" value="撤销"></tb>
            </tr>
        </table>
    </form>
</body>
</html>
````

```jsp
<%--
    Welcome.jsp
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
欢迎回来!<%=session.getAttribute("user")%>
<a href="/login/Exit">退出登录</a>
</body>
</html>
```

```java
package indi.guxiyuesi;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Check extends HttpServlet {
    //获取默认账号密码
    String user;
    String password;

    @Override
    public void init(ServletConfig config) throws ServletException {
        //通过初始化函数获取web.xml中保存的默认账号密码
        this.user = config.getInitParameter("user");
        this.password = config.getInitParameter("password");
    }

    //通过doGet方法处理请求
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求时的参数
        String user = req.getParameter("user");
        String password = req.getParameter("password");

        //如果参数和默认密码相同, 将用户名写入HttpSession对象, 并进入Welcome.jsp页面
        if(this.user.equals(user) && this.password.equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            //使用重定向但不会丢失登录状态, 因为账号保存在session中
            resp.sendRedirect("/login/Welcome.jsp");
        } else {
            resp.sendRedirect("/login/login.jsp");
        }
    }
}
```

```java
package indi.guxiyuesi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//退出登录的逻辑代码, 清除session中的内容即可
@WebServlet("/login/Exit")
public class Exit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect("/login/login.jsp");
    }
}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

    <servlet>
        <servlet-name>check</servlet-name>
        <servlet-class>indi.guxiyuesi.Check</servlet-class>

        <init-param>
            <param-name>user</param-name>
            <param-value>admin</param-value>
        </init-param>

        <init-param>
            <param-name>password</param-name>
            <param-value>admin</param-value>
        </init-param>
    </servlet>

    <servlet-mapping>
        <servlet-name>check</servlet-name>
        <url-pattern>/login/check</url-pattern>
    </servlet-mapping>
</web-app>
```





## 4. Cookie

Cookie是服务器在HTTP响应中附带传给浏览器的一个==小文本文件==, 以但浏览器保存了某个Cookie, 在之后的请求和响应过程中, 会将次Cookie来回传递, 这样就可以通过Cookie这个载体完成客户端和服务端的数据交互

java中通过`Cookie`类来操作Cookie, 通过`key-value` 形式来存储对象

+ 创建Cookie, 响应到客户端

  ```java
  Cookie cookie = new Cookie("name", "tom");
  response.addCookie(cookie);
  ```

+ 读取Cookie

  ```java
  Cookie[] cookies = request.getCookies();
  for(Cookie cookie:cookies) {
      System.out.println(cookie.getName());
      System.out.println(cookie.getValue());
  }
  ```

Cookie 常用方法:

`void setMaxAge(int age)`          设置cookie的有效时间, 单位为秒

`int getMaxAge()`            获取cookie的有效时间      默认-1, 指关闭浏览器cookie就失效

`String getName()`           获取Cookie的name

`String getValue()`          获取Cookie的value

+ 使用Cookie保存登录信息:

  ```jsp
  <%-- /cookieLogin/login.jsp  登录页面--%>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <html>
  <head>
      <title>Login</title>
  </head>
  <body>
      <h1>登录</h1>
      <form action="/cookieLogin/check" method="post">
          <table>
              <tr>
                  <tb>用户名:</tb>
                  <tb><input type="text" name="user"/></tb>
              </tr><br/>
  
              <tr>
                  <tb>密码:</tb>
                  <tb><input type="password" name="password"/></tb>
              </tr><br/>
  
              <tr>
                  <tb><input type="submit" value="登录"/></tb>
                  <tb><input type="reset" name="撤销"/></tb>
              </tr><br/>
          </table>
      </form>
  </body>
  </html>
  ```

  ```jsp
  <%-- /cookieLogin/Welcome.jsp  登录成功页面 --%>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <html>
  <head>
      <title>Welcome</title>
  </head>
  <body>
      欢迎回来!
      <%
          Cookie[] cookies = request.getCookies();
          String user = null;
          for (Cookie cookie:cookies) {
              if(cookie.getName().equals("user")) {
                  user = cookie.getValue();
                  break;
              }
          }
      %>
      <%= user %>
      <a href="/cookieLogin/exit">退出登录</a>
  </body>
  </html>
  ```

  ```java
  //登录检查逻辑
  @WebServlet("/cookieLogin/check")
  public class CookieLoginCheck extends HttpServlet {
      String user = "admin";
      String password = "admin";
      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          String user = req.getParameter("user");
          String password = req.getParameter("password");
          if(this.user.equals(user) && this.password.equals(password)) {
              Cookie cookie = new Cookie("user", user);
              //必须有
              resp.addCookie(cookie);
              resp.sendRedirect("/cookieLogin/Welcome.jsp");
          } else {
              resp.sendRedirect("/cookieLogin/login.jsp");
          }
      }
  }
  ```

  ```java
  //退出登录逻辑
  @WebServlet("/cookieLogin/exit")
  public class CookieExit extends HttpServlet {
      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          Cookie[] cookies = req.getCookies();
          for(Cookie cookie : cookies) {
              if(cookie.getName().equals("user")) {
                  cookie.setMaxAge(0);
                  //必须有
                  resp.addCookie(cookie);
                  break;
              }
          }      
          resp.sendRedirect("/cookieLogin/login.jsp");
      }
  }
  ```

  



## 5. JSP内置对象作用域

主要讨论可以传输数据的4个内置对象:

`page`, `request` , `session` , `application` 

1. ==page作用域== : 对应的内置对象是 `pageContext` 
2. ==request作用域== : 对应的内置对象是 `request`
3. ==session作用域== : 对应的内置对象是 `session`
4. ==application作用域== : 对应的内置对象是 `application`

`page` < `request`   < `session`  < `application`

+ `page` : 只在当前页面有效
+ `request` : 只在一次请求内有效, ==请求转发==参数依然有效
+ `session` : 在一次会话内有效, ==请求转发== 和 ==重定向== , ==同一次浏览器中的多个页面==
+ `application` : 对应整个WEB应用的   ==只要服务器不关闭, 任何客户端访问的参数都一样== 

```jsp
<%-- 统计访问服务器的人数 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Count</title>
</head>
<body>
    <%
        Integer count = (Integer) application.getAttribute("count");
        if (count == null) {
            count = 1;
            application.setAttribute("count", 1);
        } else {
            count ++;
            application.setAttribute("count", count);
        }
    %>
    您是第<%=count%>位浏览的用户!
</body>
</html>
```

## 6. EL表达式

### 6.1 EL表达式的含义

EL: Eepression Language表达式语言, 替代JSP页面中的==数据访问== 时的复杂编码, 可以==非常便捷的取出域对象中保存的数据(pageContext, request, session, application)== 前提是要先`setAttribute()` , 即EL是一种简化了`getAttribute()` 的语言

语法: `${变量名}` 变量名就是`setAttribute()` 中设置的key值

#### EL表达式的查找顺序

1. 默认查找顺序
   `pageContext` -> `request` -> `session` -> `application` 
   沿着箭头顺序依次查找, 一旦找到key立即返回
2. 指定作用域查找
   语法: 
   `pageContext` : `${pageScope.key}` 
   `request` : `${requestScope.key}` 
   `session` : `${sessionScope.key}` 
   `application` : `${applicationScope.key}` 

```jsp
<%-- 输出结果:pageContext session --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL1</title>
</head>
<body>
    <%
        pageContext.setAttribute("name", "pageContext");
        request.setAttribute("name", "request");
        session.setAttribute("name", "session");
        application.setAttribute("name", "application");
    %>

    ${name}
    ${sessionScope.name}
</body>
</html>
```

3. EL表达式可以很方便的取出==类的信息== 

```jsp
<%-- 
结果:
编号 姓名 年龄
15	张三	88

人物综合信息:User{name='张三', Id=15, score=88} 
人物综合信息:User{name='张三', Id=15, score=88}    

EL表达式输出类信息解析:
$(person) , 默认调用了user中的toString()方法, 等价于request.getAttribute("person").toString()
$(person.id) , 默认经过了两步骤: 
	1. id -> Id
    2. Id -> getId
然后通过反射调用getId() 方法, 等价于 request.getAttribute("person").getId()
即: EL表达式并不是直接访问属性, 而是通过反射访问对应的get方法
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
```

4. EL表达式也可以用来赋值, 但是并不方便, 很少使用, 语法: `${user.id = 3}`, 即先调用了`setId` 方法, 然后再调用 `getId` 方法

5. EL 执行表达式
   + 与       `&&` 或 `and`
   +  或       `||` 或 `or` 
   + 非       `!` 或  `not`
   + 等于     `==` 或 `eq` 
   + 不等于   `!=` 或 `ne`
   + 小于      `<` 或 `lt`
   + 大于      `>` 或 `gt` 
   + 大于等于  `>=` 或 `ge` 
   + 小于等于   `<=` 或 `le` 
   + `empty`        变量为null, 长度为0的字符串, size为0的集合
     `$(empty sessionScope.num3)`  判断num3是否为空并输出

## 7. JSTL

JSP Standard Tag        JSP标准标签库, JSP为开发者提供的一系列的标签, 使用这些标签可以完成一些逻辑处理, 如循环遍历等, 当代码更加简洁, 不再出现JSP脚本穿插的情况

### 7.1 JSTL的使用

1. 在项目中导入两个jar包(必须导入到 `web/WEB-INF` 下的文件夹中)
   `jstl.jar`    `standard.jar` 
2. 在JSP页面开始的地方导入JSTL标签库
3. 在需要的地方使用

```jsp
<c:forEach var="user" items="${users}">
    ${user}<br/>
</c:forEach>
```

### 7.2 JSTL中的常用标签

1. `set` 向域对象中添加/修改数据

   ```jsp
   <c:set var="name" value="hello" scope="request"></c:set>
   <c:set  target="${user}" property="name" value="abc"></c:set>
   ${requestScope.name}
   ${user.name}
   ```

   注意:

   1. `target` 和 `scope` 不能同时存在
   2. `var` 中不能有表达式

2. `out` 功能基本等同于`${}` 但是可以设置默认值

   ```jsp
   <c:set var="name" value="hello" scope="request"></c:set>
   <c:out value="${name}" default="未定义"></c:out><br/>
   <c:out value="${w}" default="未定义"></c:out>
   
   <%-- 
   输出结果:    
   hello
   未定义
   --%>
   ```

3. `remove` 删除域对象中的数据

   ```jsp
   <c:set var="name" value="hello" scope="request"></c:set>
   <c:out value="${name}" default="未定义"></c:out><br/>
   <c:remove var="name" scope="request"></c:remove>
   <c:out value="${name}" default="未定义"></c:out>
   <%-- 
   输出结果:    
   hello
   未定义
   --%>
   ```

4. `catch` 捕获异常

   ```jsp
   <c:catch var="error">
       <%
       int i = 10 / 0;
       %>
   </c:catch>
   ${error}
   
   <%--
   java.lang.ArithmeticException: / by zero
   --%>
   ```

5. 条件判断标签        `if`     `choose`

   ```jsp
   <%
   int num1 = 1;
   int num2 = 2;
   request.setAttribute("num1", num1);
   request.setAttribute("num2", num2);
   %>
   <c:if test="${num1 > num2}" >true</c:if>
   <c:if test="${num1 <= num2}" >false</c:if>
   
   <hr/>
   
   <c:choose>
       <c:when test="${num1 > num2}">true</c:when>
       <c:otherwise>false</c:otherwise>
   </c:choose>
   ```

6. 循环遍历标签   `forEach` 

   ```jsp
   <%-- 
   items : 遍历的集合
   var : 遍历时的遍历名
   begin : 开始下标
   end : 结束下标
   step : 步长
   varStatus : 遍历过程中的一些属性值
   --%>
   
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
   
   <%-- 
   1-3
   2-5
   3-7
   4-9
   --%>
   ```

7. 格式化标签库常用标签

   ```jsp
   <%
   	request.setAttribute("date", new Date());
   %>
   <fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate><br/>
   <fmt:formatNumber value="432.532" maxIntegerDigits="2" maxFractionDigits="1"></fmt:formatNumber>
   
   <%--
   2021-10-04 21:37:56
   32.5
   --%>
   ```

### 8. 案例

```java
package indi.guxiyuesi;

/**用户信息类  User类 */
public class User {
    private int id;
    private String name;
    private int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

```java
package indi.guxiyuesi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**前后端交互类 UserServlet类*/
@WebServlet("/index")
public class UserServlet extends HttpServlet {
    /** users 保存用户信息, 用来在request中保存后进入其他jsp界面
     *  无论UserServlet类被访问几次, users只创建一次, 因为UserServlet是单例模式
     * */
    private Map<Integer, User> users;

    /** 初始化users中的参数 模拟从数据库中取值
     * */
    public  UserServlet() {
        users = new HashMap<>();
        users.put(1, new User(1, "张三", 86));
        users.put(2, new User(2, "李四", 78));
        users.put(3, new User(3, "王五", 10));
    }

    /** doGet 类主要负责浏览器 或 a标签提交的请求
     * */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码形式, 防止乱码
        req.setCharacterEncoding("UTF-8");
        //获取请求中的method参数, 如果为null, 赋予默认值为findAll
        String method = req.getParameter("method");
        if(method == null) {
            method = "findAll";
        }

        /** method == findAll : 展示数据
         *  method == add : 进入添加数据界面
         *  method == delete : 直接删除数据并展示删除后的数据
         *  method == update : 进入修改数据界面
         * */
        if(method.equals("findAll")) {
            req.setAttribute("users", users);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else if(method.equals("add")) {
            resp.sendRedirect("add.jsp");
        } else if(method.equals("delete")) {
            int key = Integer.parseInt(req.getParameter("key"));
            users.remove(key);
            resp.sendRedirect("/index");
        } else if(method.equals("update")) {
            int key = Integer.parseInt(req.getParameter("key"));
            User user = users.get(key);
            req.setAttribute("user", user);
            req.getRequestDispatcher("/update.jsp").forward(req, resp);
        }
    }

    /** doPost 主要负责从表单中传递的数据*/
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id =req.getParameter("id");
        String name = req.getParameter("name");
        String age =req.getParameter("age");
        try {
            users.put(Integer.parseInt(id), new User(Integer.parseInt(id), name, Integer.parseInt(age)));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //重新进入并展示添加或修改后的数据
            resp.sendRedirect("/index");
        }

    }
}

```

```jsp
<%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-04
  Time: 22:11
  To change this template use File | Settings | File Templates.
      
   index.jsp
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Information</title>
  </head>
  <body>
    <form action="/index" method="get">
      <table>
        <tr>
          <th>编号</th>
          <th>姓名</th>
          <th>年龄</th>
        </tr>

        <c:forEach items="${users}" var="user" >
          <tr>
            <td>${user.value.id}</td>
            <td>${user.value.name}</td>
            <td>${user.value.age}</td>
            <td><a href="/index?method=delete&key=${user.value.id}">删除</a>
                <a href="/index?method=update&key=${user.value.id}">修改</a></td>
          </tr>
        </c:forEach>

      </table><br/>

    </form>
    <a href="/index?method=add">添加</a>
  </body>
</html>

```

```jsp
<%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-04
  Time: 23:13
  To change this template use File | Settings | File Templates.
      
  add.jsp
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
    <form action="/index" method="post">
        编号:<input type="text" name="id" /><br/>
        姓名:<input type="text" name="name" /><br/>
        年龄:<input type="text" name="age" /><br/>
        <input type="submit" value="添加">
    </form>
</body>
</html>
```

```jsp
<%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-10-04
  Time: 23:54
  To change this template use File | Settings | File Templates.
      
  update.jsp
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
    <form action="/index" method="post">
        编号:<input type="text" name="id" value="${user.id}" readonly/><br/>
        姓名:<input type="text" name="name" value="${user.name}" /><br/>
        年龄:<input type="text" name="age" value="${user.age}"/><br/>
        <input type="submit" value="修改">
    </form>
</body>
</html>

```



