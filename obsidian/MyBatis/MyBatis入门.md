---
tags: Mybatis 框架 持久层
---
# MyBatis入门
实现数据持久化的ORM框架, 同时支持java, .NET,  Ruby三种语言.
MyBatis是一个对JDBC进行封装的框架
Mybatis对所有的JDBC进行了封装, 包括**参数设置**, **SQL执行**, **结果集解析**等,  通过**XML配置/注解**的方式完成POJO与数据之间的映射.

### MyBatis优点
+ 简化了JDBC代码的开发
+ 简单好用, 容易上手, 具有更好的灵活性
+ 通过将SQL定义在xml中的方式, 可以降低程序的耦合性
+ 支持动态SQL, 可以根据具体的业务需求灵活实现功能


### MyBatis缺点
+ 像比如Hibernate, 开发者要做的更多
+ 要求开发人员有SQL编程的能力
+ 数据库的移植性差 

### MyBatis的快速搭建

 1. 创建Maven工程, 在pom.xml中引入依赖: Mybatis 和数据库驱动
```xml
<!-- MyBatis依赖 -->
<dependency>
	<groupId>org.mybatis</groupId>
	<artifactId>mybatis</artifactId>
	<version>3.4.5</version>
</dependency>

<!-- MySQL驱动 -->
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>8.0.19</version>
</dependency>

``` 
2. 创建实体类
```java
@Data  
public class Doctor {  
 private String doctorId;  
 private String doctorName;  
 private String doctorGender;  
 private String doctorPhoneNumber;  
 private Integer doctorAge;  
 private Integer departmentId;  
 private Integer doctorCurrentNumber;  
 private Integer doctorCurrentAllNumber;  
 private Integer doctorDefaultAllNumber;  
 private String doctorPassword;  
 private Integer isDoctor;  
}
```
3. 配置数据库连接信息: 在resources路径下配置`config.xml`(文件名可自定义)


	config.xml的头文件
```xml
<?xml version="1.0" encoding="UTF-8" ?>
        <!DOCTYPE configuration
                PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
                "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

</configuration>
```
具体配置:
```xml
<?xml version="1.0" encoding="UTF-8" ?>  
<!DOCTYPE configuration  
 PUBLIC "-//mybatis.org//DTD Config 3.0//EN"  
 "http://mybatis.org/dtd/mybatis-3-config.dtd">  
<configuration>  
 <!-- 配置MyBatis的运行环境 可以配置多个数据源 -->  
 <environments default="development">  
 <environment id="development">  
 <transactionManager type="JDBC"></transactionManager>  
 <!-- 数据源 -->  
 <dataSource type="POOLED">  
 <!-- 数据库驱动 -->  
 <property name="driver" value="com.mysql.cj.jdbc.Driver"/>  
 <!-- 数据库url  
 防止中文乱码: url后加属性: useUnicode=True&amp;characterEncoding=UTF-8 --> 
<property name="url" value="jdbc:mysql://localhost:3306?useUnicode=True&amp;characterEncoding=UTF-8"/>  
 <!-- 数据库账号 密码-->  
 <property name="username" value="root"/>  
 <property name="password" value="339558"/>  
 </dataSource>  
 </environment>  
 </environments>  
</configuration>
```
4. 开发MyBatis.     MyBatis开发有两种方式: 
    + 使用原生接口
    + 使用Mapper代理实现自定义接口

### MyBatis使用原生接口开发
1. 创建Mapper文件  `DoctorMapper.xml`


    mapper文件完成的事情:
	+ 编写sql
	+ 完成结果集与POJO之间的映射

`DoctorMapper.xml` 的头文件
```xml
<?xml version="1.0" encoding="UTF-8" ?>
        <!DOCTYPE mapper
                PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
                "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper>
	
</mapper>

```
`DoctorMapper.xml` 的配置
```xml
<?xml version="1.0" encoding="UTF-8" ?>  
<!DOCTYPE mapper  
 PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"  
 "http://mybatis.org/dtd/mybatis-3-mapper.dtd">  
<!-- 命名空间: mapper.xml文件所在的位置, 包名+文件名 -->  
<mapper namespace="indi.guxiyuesi.HospitalManage.mapper.DoctorMapper">  
 	<select id="findById" parameterType="java.lang.String" resultType="indi.guxiyuesi.HospitalManage.entity.Doctor">  
 		select * from doctors where doctorId = #{id}  
 	</select>  
</mapper>
```
参数解读:

`id` : 用来标记是哪一个语句, 通过id来找到语句

`parameterType` : 参数的类型

`resultType` : 结果集映射的POJO路径, 通过resultType来完成结果集与POJO之间的映射

`#{id}` : 占位符

2. 在 `config.xml` 中配置mapper文件 `DoctorMapper.xml`

```xml
<mappers>  
 <mapper resource="indi/guxiyuesi/HospitalManage/mapper/DoctorMapper.xml"/>  
</mappers>
```

3. 获取查询结果

```java
public class Main {  
 public static void main(String[] args) {  
 //加载MyBatis配置文件  
 InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("config.xml");  
 //MyBatis是通过sqlSession来完成的, 因此要获取sqlSession  
 //首先new一个SqlSessionFactoryBuilder 
 SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();  
 //通过sqlSessionFactoryBuilder获取一个sqlSessionFactory  
 SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);  
 //通过sqlSessionFactory获取sqlSession  
 SqlSession sqlSession = sqlSessionFactory.openSession();  
 //调用myBatis的原生接口执行sql语句  
 //找到sql语句 
 String statement = "indi.guxiyuesi.HospitalManage.mapper.DoctorMapper.findById";  
 //执行sql语句, 并将结果集赋值给POJO  
 Doctor doctor = sqlSession.selectOne(statement, "1");  
 System.out.println(doctor);  
 }  
}

```
4. 出现的bug:

 java.io.IOException: Could not find resource indi/guxiyuesi/HospitalManage/mapper/DoctorMapper.xml
 
原因: idea默认只读取resources路径下的xml文件

解决方案: ![[idea中读取非resources路径下的xml文件#idea中读取非resources路径下的xml文件]]

