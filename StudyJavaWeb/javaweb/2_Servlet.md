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

### 示例:

java程序一般放在`src` 文件夹下, 前端代码放在`web` 包中

```java
//java源码
package indi.guxiyuesi.studyServlet;

import javax.servlet.*;
import java.io.IOException;

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
<!--xml对于java源码的映射-->
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