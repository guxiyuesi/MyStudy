# SpringMVC

## 1. SpringMVC简介

springMVC是springFramework提供的Web组件, 又名Spring Web MVC, 是目前主流的实现MVC设计模式的框架, 提供前端路由映射, 视图解析等功能.

### 1.1 Spring MVC功能

> MVC

M: Model(模型层)

V: View(视图层)

C: Controller(视图层)	

工作方式:

![image-20211024152900502](https://gitee.com/four_four/picgo/raw/master/img/20211024152900.png) 

> SpringMVC

Spring MVC是对MVC流程的封装, 帮助开发者屏蔽底层代码, 开放相关接口供开发者使用, 让MVC开发变得简单

### 1.2 SpringMVC工作流程

![image-20211024155108483](https://gitee.com/four_four/picgo/raw/master/img/20211024155108.png) 

1. **DispatcherServlet** 

   前置控制器, **负责调度其他组件执行** , 可以降低不同组件之间的耦合性, 是整个Spring MVC的核心

2. **HandlerMapping** 
   DispatcherServlet 通过 HandlerMapping 将请求映射到不同的Handler
3. **Handler** 
   处理器, 完成具体的业务逻辑, **相当于Servlet**  
4. **HandlerInterceptor** 
   处理器拦截器, 一个接口, 如果需要进行拦截处理, 可以通过实现该接口完成, **相当于Filter** 
5. **HandlerExecutionChain** 
   处理器执行链, 与Servlet中的Chain类似
6. **HandlerAdapter**
   处理器适配器, Handler执行业务之前, 需要进行一系列的数据验证, 数据类型转换, 表单数据封装成POJO等, 都是由HandlerAdapter完成.
   DispatcherServlet 通过 HanderAdapter 来执行不同的Handler
7. **ModelAndView** 
   封装了模型数据和视图信息, 作为Handler处理完的结果返回给DispatcherServlet
8. **ViewResolver** 
   视图解析器, 将逻辑视图解析为物理视图, 最终将结果相应给客户端

> 物理视图

具体的视图文件 , 如index.jsp 就是物理视图

> 逻辑视图

本质上就是一串字符串, 通过这一串字符串可以找到物理视图





## 2. SpringMVC快速入门

1. 创建maven工程, 选择`create from archetype` -> `maven-archetype-webapp` , 如果使用的是镜像仓库, 需要在 `File->setting->Build, Execution, Deployment->Build Tools-> Maven -> Runner -> VM Options` 中输入 
   `-DarchetypeCatalog=internal` 

2. 在pom.xml 中配置 springmvc依赖

   ```xml
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-webmvc</artifactId>
       <version>5.3.10</version>
   </dependency>
   ```

3. 在 web.xml中配置 DispatcherServlet

   ```xml
   <servlet>
       <servlet-name>springMVC</servlet-name>
       <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
       <init-param>
           <!-- 在配置DispatcherServlet时加载初始化配置 -->
           <param-name>contextConfigLocation</param-name>
           <param-value>classpath:springMVC.xml</param-value>
       </init-param>
   </servlet>
   
   <servlet-mapping>
       <servlet-name>springMVC</servlet-name>
       <url-pattern>/</url-pattern>
   </servlet-mapping>
   ```

4. 在springmvc.xml中配置自动扫描和视图解析器

   ```xml
   <?xml version="1.0" encoding="utf-8" ?>
   <beans
           xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:context="http://www.springframework.org/schema/context"
           xmlns:p="http://www.springframework.org/schema/p"
           xsi:schemaLocation="http://www.springframework.org/schema/beans
                              http://www.springframework.org/schema/beans/spring-beans-3.2.xsd
                              http://www.springframework.org/schema/context
                              http://www.springframework.org/schema/context/spring-context-4.3.xsd">
   
       <!-- base-package 是从src.java包开始扫描的 -->
       <context:component-scan base-package="com.guxiyuesi"></context:component-scan>
   
       <!-- 配置视图解析器 : 找到返回的视图位置 -->
       <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
           <!-- 前缀 -->
           <property name="prefix" value="/"></property>
           <!-- 后缀 -->
           <property name="suffix" value=".jsp"></property>
       </bean>
   </beans>
   ```

5. 创建Handler

   ```java
   package com.guxiyuesi.controller;
   
   import org.springframework.stereotype.Controller;
   import org.springframework.web.bind.annotation.RequestMapping;
   
   /**
    * @author 叶意
    * @ClassName HelloHandler
    * @Description TODO
    * @createTime 2021年10月24日  15:15:00
    */
   
   @Controller
   public class HelloHandler {
       //配置浏览器进入该方法的路径 相当于@WebServlet
       @RequestMapping("/index")
       public String index() {
           System.out.println("接收请求");
           return "index";
       }
   }
   ```

   

## 3. SpringMVC常用注解

### 3.1 `@RequestMapping`

Spring MVC通过 @RequestMapping 注解将 URL请求与业务方法进行映射, 功能类似于 `@WebServlet`

可以在Handler的**类定义处** 和 **方法定义处** 添加
在 **类定义处** 时添加, 相当于**多一层访问路径**

```java
@Controller
@RequestMapping("/myTest")
public class HelloHandler {
    //配置浏览器进入该方法的路径 相当于@WebServlet
    @RequestMapping("/index")
    public String index() {
        System.out.println("接收请求");
        return "index";
    }
}
/*
访问路径: http://localhost:8080/myTest/index
*/
```

> 常用参数

1. value: 指定URL请求的实际地址
2. method : 指定请求的方式, 包括 GET, POST, DELETE, PUT等
3. params : 指定request请求中必须包含的参数值, 若不包含则无法调用
   如果参数已经指定了值, 则必须按照指定的值传参, 否则无法调用

```java
@Controller
@RequestMapping(value = "/myTest")
public class HelloHandler {
    //配置浏览器进入该方法的路径 相当于@WebServlet
    @RequestMapping("/index", method = RequestMethod.GET, params = {"name", "id=1"})
    public String index() {
        System.out.println("接收请求");
        return "index";
    }
}
/*
以上代码表示, 请求中必须包含name, id这两个参数, 且id必须等于1
以下的URL可以调用:
	http://localhost:8080/myTest/index?name=张三&id=1
	http://localhost:8080/myTest/index?name=李四&id=1
	http://localhost:8080/myTest/index?name=李四&id=1&v=2
	http://localhost:8080/myTest/index?id=1&name=张三
	http://localhost:8080/myTest/index?name&id=1
以下的URL不能调用:
	http://localhost:8080/myTest/index?name=张三
	http://localhost:8080/myTest/index?id=1
	http://localhost:8080/myTest/index?name=张三&id=2
*/
```

### 3.2 `@RequestParam` 

将URL中的参数绑定到方法中时, 使用 `@requestParam` 注解

如果 指定的URL中的参数值与方法中的参数值的名字相同, 可以不使用@RequestParam注解

```java
@Controller
@RequestMapping(value = "/myTest")
public class HelloHandler {
    //配置浏览器进入该方法的路径 相当于@WebServlet
    @RequestMapping( value = "/index", method = RequestMethod.GET, params = {"name", "id=1"})
    public String index(@RequestParam("name") String myName, Integer id) {
        System.out.println("name="+myName + "  id=" + id);
        return "index";
    }
}

/*
URL:http://localhost:8080/myTest/index?name=张三&id=1
输出:
name=张三  id=1
*/
```

#### Restful风格的URL参数获取

传统url : http://localhost:8080/myTest/index?name=张三&id=1

restful url : http://localhost:8080/myTest/index/张三/1

```java
@Controller
@RequestMapping(value = "/myTest")
public class HelloHandler {
    //配置浏览器进入该方法的路径 相当于@WebServlet
    @RequestMapping( value = "/index/{name}/{id}", method = RequestMethod.GET)
    public String index(@PathVariable("name") String myName, @PathVariable("id") Integer id) {
        System.out.println("name="+myName + "  id=" + id);
        return "index";
    }
}


/*
url:http://localhost:8080/myTest/index/mary/1
输出:
name=mary  id=1
*/
```

### 3.3 Cookie

```java
@RequestMapping( value = "/cookie", method = RequestMethod.GET)
public String myCookie(@CookieValue("JSESSIONID") String sessionID) {
    System.out.println(sessionID);
    return "index";
}
```
JSP中的Cookie: [[3_JSP#4 Cookie|Cookie]]
### 3.4 使用POJO绑定参数

Spring MVC会根据请求参数名和POJO属性名进行匹配, 支持级联

**主体对象可以没有无参构造参数, 但是级联对象必须有无参构造函数** 

```java
@RequestMapping(value = "/pojo", params = {"name", "id"})
public String myPOJO(User user) {
    System.out.println(user);
    return "index";
}
/*




url: http://localhost:8080/


输出结果:
输出结果:
User(name=mary, id=1)
*/
```

> 级联绑定参数实例

```jsp
//前端表单
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
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
        <input type="submit" value="提交" />
    </table>
</form>
</body>
</html>
```

```java
//User类
@Data
public class User {
    private String name;
    private int id;
    private Address address;
}
```

```java
//Address类
@Data
public class Address {
    private String name;
}
```

```java
//Handler
@RequestMapping(value = "/pojo")
public String myPOJO(User user) {
    System.out.println(user);
    return "index";
}
/*
输出结果:
User(name=张三, id=4, address=Address(name=dsafdas))
*/
```



## 4. SpringMVC响应jsp页面

SpringMVC默认以转发的形式响应jsp, 当然也可以指定响应模式为: 转发 or 重定向

```java
//转发
@RequestMapping(value = "/forward")
public String forwardRespond() {
    return "forward:/index.jsp";
}

//重定向
@RequestMapping(value = "redirect")
public String redirectRespond(){
    return "redirect:/index.jsp";
}
```



## 5. Spring MVC数据绑定

### 5.1 数组类型    

从前端传输来的数据所带的参数名必须与handler的形参相同

```java
@RequestMapping("/arrayType")
@ResponseBody
public String arrayType(String[] names){
    StringBuilder stringBuilder = new StringBuilder();
    for (String name:names) {
        stringBuilder.append(name + " ");
    }
    return stringBuilder.toString();
}
/*
url : localhost:8080/myTest/arrayType?names=mary&names=tom
输出: mary tom
*/
```

### 5.2 POJO 

```java
//Address类
@Data
public class Address {
    private String name;
}
```



```java
//简单实体类
@Data
public class User {
    private String name;
    private int id;
    private Address address;
}
```

```java
//handler
/*
url : localhost:8080/myTest/pojo?name=mary&id=1&address.name=china
输出 : User(name=mary, id=1, address=Address(name=china))
*/
@RequestMapping(value = "/pojo")
@ResponseBody
public String myPOJO(User user) {
    System.out.println(user);
    return user.toString();
}
```

### 5.3 集合类型

集合类型不能直接绑定, 必须要将集合包装成类才能进行绑定

#### 5.3.1 list与set

list与set的绑定方式完全相同, 这里以list举例

```java
//User类
@Data
public class User {
    private Integer id;
    private String name;
}
```

```java
//User的list包装类
@Data
public class UserList {
    List<User> users = new ArrayList<>();
}
```

```java
//handler
//前端传输数据时, 并不是使用userlist作为名, 而是使用其属性 users 作为名
@RequestMapping(value = "/myList", method = RequestMethod.POST)
@ResponseBody
public String myList(UserList userlist) {
    StringBuilder stringBuilder = new StringBuilder();
    for (User user : userlist.getUsers()) {
        stringBuilder.append(user.toString() + "\n");
    }
    return stringBuilder.toString();
}
```

```jsp
<!-- 前端form表格 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/myHandler/myList" method="post">
        用户1 编号 : <input type="text" name="users[0].id"/><br/>
        用户1 姓名 : <input type="text" name="users[0].name"/><br/>
        用户2 编号 : <input type="text" name="users[1].id"/><br/>
        用户2 姓名 : <input type="text" name="users[1].name"/><br/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
```

#### 5.3.2 Map集合

map与list, set类似, 只是前端绑定的方式略微不同

```java
//User 的 Map集合包装类
@Data
public class UserMap {
    private Map<String, User> users = new HashMap<>();
}
```

```jsp
<!-- 前端代码 -->
<form action="/myHandler/myMap" method="post">
    <!-- 这里的a, b都是map里的key -->
    用户1 编号 : <input type="text" name="users['a'].id"/><br/>
    用户1 姓名 : <input type="text" name="users['a'].name"/><br/>
    用户2 编号 : <input type="text" name="users['b'].id"/><br/>
    用户2 姓名 : <input type="text" name="users['b'].name"/><br/>
    <input type="submit" value="提交"/>
</form>
```

### 5.4 JSON

JSON对象字符串 不能直接绑定, 需要使用json转换器, 这里使用fastjson

1. 导入fastjson依赖

   ```xml
   <dependency>
       <groupId>com.alibaba</groupId>
       <artifactId>fastjson</artifactId>
       <version>1.2.78</version>
   </dependency>
   ```

2. 配置fastjson使其生效

```xml
<!-- 注册注解驱动 -->
<mvc:annotation-driven >
    <!-- 配置消息转换器 -->
    <mvc:message-converters>
        <!-- 编码转换 -->
        <bean class="org.springframework.http.converter.StringHttpMessageConverter">
            <property name="supportedMediaTypes" value="text/html;charset=UTF-8"></property>
        </bean>
        <!-- JSON格式转换  配置fastJSON -->
        <bean class="com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter"></bean>
    </mvc:message-converters>
</mvc:annotation-driven>
```

## 6. 视图层解析

### 6.1 