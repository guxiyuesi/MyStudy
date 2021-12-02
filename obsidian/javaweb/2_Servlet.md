# Servlet

## 1. Servlet简介

### 1.1 什么是Servlet

==Servlet== 是javaweb开发的基石, 是一种==与平台无关的服务器组件== , 运行在 ==Servlet容器/Web服务器/Tomcat== , 负责与==客户端== 进行通信.

主要功能:

1. 创建并返回基于==客户请求的== 动态HTML界面
2. 可以与==数据库== 进行通信

### 1.2 如何使用Servlet

Servlet本身是==一组接口== , 在==javax.servlet== 包中, 只需要自定义一个类, 并且实现Servlet接口, 则这个类就具备了==接收客户端请求== 和 ==做出响应== 的功能

`java` 与 `javax` :

​	两者都是jdk中提供的, `java` 是基础, `javax` 是后来扩展的

### 1.3 Servlet访问

java程序一般放在`src` 文件夹下, 前端代码放在`web` 包中

```java
//java源码
package indi.guxiyuesi.studyServlet;

import javax.servlet.*;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;

//配置的第二种方式, 通过注解配置, 直接在注解中加相对路径即可
@WebServlet("/demo1")
public class FirstServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //接收来自客户端的参数
        String str = servletRequest.getParameter("id");
        //设置响应时的格式和编码
        servletResponse.setContentType("text/HTML; charset=UTF-8");
        //像客户端返回的内容
        servletResponse.getWriter().write("我已接收到客户端请求! 请求id="+str);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
```

```xml
<!--xml对于java源码的映射, 只有映射后src中的文件才能被访问到-->
<!--这是第一种映射方式, 通过配置xml文件来进行映射-->
<servlet>
        <servlet-name>TestServletMapping</servlet-name>
        <servlet-class>indi.guxiyuesi.studyServlet.FirstServlet</servlet-class>
    </servlet>

<servlet-mapping>
    <servlet-name>TestServletMapping</servlet-name>
    <url-pattern>/t</url-pattern>
</servlet-mapping>
```

运行结果:

![image-20210929225048412](https://gitee.com/four_four/picgo/raw/master/img/20210929225048.png) 

### 1.4 Servlet的生命周期

`创建对象` -> `初始化` -> `运行` -> `销毁` 
对应的生命周期方法:

1. 当浏览器访问Servlet时, Tomcat会查询到当前Servlet的实例化对象是否存在, 如果不存在则通过==反射== 机制动态创建对象; 如果存在, 直接执行步骤3
2. 调用 ==init== 方法完成初始化
3. 调用 ==service== 方法完成业务逻辑操作
4. 关闭tomvat 时, 会调用 ==destory== 方法, 释放当前对象所占用的资源

+ java 的反射机制:
  1. 源文件经过编译后会形成`.class` 
  2. 程序运行时将`.class` 文件加载到方法区
  3. 通过`.class` 文件的构造器动态的创建对象

+ Tomcat通过反射获取到Servlet对象的过程:
  1. 浏览器输入映射后的 `<url-pattern>` 后, tomcat通过 `servlet-name` 找到 `servlet-class` 
  2. 通过servlet的class文件动态创建对象



Servlet的生命周期方法:

1. 构造方法: 只调用一次, 用来创建对象
2. `init`  : 初始化方法, 只调用一次, 用来初始化对象
3. `service` : 业务方法, 调用n次
4. `destory` : 调用1次, 用来销毁对象

```java
/* 运行时报错: Exception in thread "main" java.lang.NoClassDefFoundError: javax/servlet/Servlet
* 原因: javax/servlet/Servlet 在Tomcat的库下, javase无法访问, 需要额外导库
* 解决方案:
*   1. 在项目目录/web目录下再创建一个lib目录, 将所需的 servlet-api.jar 包放入其中
*   2. 点击 File -> Product Structure -> Library -> + -> 将lib目录下的 servlet-api.jar 包引入为library
*   之后该程序就可以运行了
* */
public class Main {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("indi.guxiyuesi.studyServlet.FirstServlet");
            Constructor constructor = c.getConstructor();
            FirstServlet fs = (FirstServlet) constructor.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```



### 1.5 ServletConfig

该接口是用来==描述Servlet的基本信息的== 

+ `getServletName()`    返回Servlet的名字(==全类名, 即包名+类名== )
+ `getInitParameter(String key)` 获取init参数的值(在`web.xml` 中配置映射时, 通过Servlet下的`<init-param>` 标签配置)
+ `getInitParameternames()` 获取所有的`param-name`并返回一个`Enumeration` 集合 , 一般用作遍历所有的初始化参数
+ `getServletContext()`  返回`ServletContext` 对象, 它是Servlet的上下文(我觉得这里理解为环境更好), 是整个 Servlet 的管理者

```java
//Servlet接口的实现类中的init方法
	public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化了FirstServlet对象");
        System.out.println(servletConfig.getServletName());
        Enumeration<String> enumeration = servletConfig.getInitParameterNames();
        while (enumeration.hasMoreElements()) {
            String s = enumeration.nextElement();
            System.out.println(servletConfig.getInitParameter(s));
        }

        ServletContext sc = servletConfig.getServletContext();
        //获取当前Servlet的虚拟路径 这里为空
        System.out.println(sc.getContextPath());
        //获取运行当前Servlet的Tomcat服务器信息
        System.out.println(sc.getServerInfo());
    }

/* 运行结果: 
初始化了FirstServlet对象
TestServletMapping
339558
s
guxiyuesi

Apache Tomcat/9.0.53
*/
```

对应的 `web.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
    <servlet>
        <servlet-name>TestServletMapping</servlet-name>
        <servlet-class>indi.guxiyuesi.studyServlet.FirstServlet</servlet-class>
        <init-param>
            <param-name>user</param-name>
            <param-value>guxiyuesi</param-value>
        </init-param>

        <init-param>
            <param-name>password</param-name>
            <param-value>339558</param-value>
        </init-param>

        <init-param>
            <param-name>type</param-name>
            <param-value>s</param-value>
        </init-param>
    </servlet>

    <servlet-mapping>
        <servlet-name>TestServletMapping</servlet-name>
        <url-pattern>/t</url-pattern>
    </servlet-mapping>
</web-app>
```



+ `ServletConfig` 与 `ServletContext` 的区别
  + `ServletConfig` 作用域某个 Servlet 实例, ==每个== Servlet 都对应==自己的==  `ServletConfig` 
    `ServletContext` 作用于整个web应用, ==多个==  Servlet 对应 ==一个== `ServletContext` 
  + `ServletConfig` 是局部对象
    `ServletContext` 是全局对象



### 1.6 Servlet的层次结构

`Servlet` -> `GenericServlet` -> `HttpServlet` 

常用的是 `HttpServlet` 

Http请求的类型:

+ `Get` 读取
+ `POST` 保存
+ `PUT` 修改
+ `DELETE` 删除

`HttpServlet` 对请求进一步细化

直接在地址栏访问时, 服务器做出响应用的是`GET` 请求

`GenericServlet` 实现Servlet接口, 同时为它的子类屏蔽了不常用的方法, 子类只需要重写 `service` 方法即可

`HttpServlet` 继承 `GenericServlet` , 根据请求类型进行分发处理, 如`GET` 进入 `doGet` 方法, `POST` 进入 `doPost` 方法

```java
//建议GenericServlet实现
package indi.guxiyuesi;

import javax.servlet.*;
import java.io.IOException;

//对Servlet接口中的方法做空实现,屏蔽了不重要的方法, 子类只需要重写需要的方法即可
public class MyGenericServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
```

```java
//对HttpServlet的简单实现
package indi.guxiyuesi;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyHttpServlet extends MyGenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //把ServletRequest, ServletResponse强转成子类 HttpServletRequest, HttpServletResponse
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;

        String method = httpServletRequest.getMethod();
        switch (method) {
            case "GET":
                doGet(httpServletRequest, httpServletResponse);
                break;
            case "POST":
                doPost(httpServletRequest, httpServletResponse);
                break;
        }
    }

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {

    }

    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {

    }

}
```

```java
/*测试MyHttpServlet类	*/
package indi.guxiyuesi;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo")
public class myTest extends MyHttpServlet {
    @Override
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.getWriter().write("GET");
    }

    @Override
    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.getWriter().write("POST");
    }
}
```

运行截图:

![image-20211001121556130](https://gitee.com/four_four/picgo/raw/master/img/20211001121556.png) 



