### ajax进行前后端交互时的编码问题
在springMVC.xml中配置注解驱动, 来防止交互时的编码问题
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