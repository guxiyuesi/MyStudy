## jsp无法引用外部css, js等资源
### 直接进入时无法加载css文件
如果创建的是spring MVC项目, 则可能是因为静态拦截器拦截了css等资源, 解决方法如下:
第一步, 在springMVC.xml中配置`<mvc:default-servlet-handler/>`, 即启用默认的servlet

第二步, 在web.xml中增加对静态资源的处理
```xml
<servlet-mapping>  
 <servlet-name>default</servlet-name>  
 <url-pattern>/js/*</url-pattern>  
 <url-pattern>/css/*</url-pattern>  
 <url-pattern>/image/*</url-pattern>  
</servlet-mapping>
```

注意这里如果爆红, 则在web.xml中引入的DTD版本应当升级到3.0, 使一个`servlet-mapping` 中可以有多个 `url-pattern`

简而言之, 更换头文件如下:
```xml
<?xml version="1.0" encoding="UTF-8"?>  
<web-app xmlns="http://java.sun.com/xml/ns/javaee"  
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
 xsi:schemaLocation="http://java.sun.com/xml/ns/javaee  
 http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" version="3.0">
<web-app>
```

### 后端跳前端时无法加载css文件
jsp引用css时使用绝对路径, 即href引用的路径从 `<%= request.getContextPath() %>` 开始

```jsp
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/login.css" charset="GBK"/>
```