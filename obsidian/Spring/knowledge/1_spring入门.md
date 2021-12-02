# Spring Framework 5

## 1. Spring两大核心机制

1. **IoC**   控制反转                 工厂模式

2. **AOP**  面向切面编程           代理模式

### 1.1 IoC

IoC是Spring框架的灵魂, 反转了对象的创建方式. 

传统方式:

```java
Student stu = new Student();
```



#### 1.1.1 开发步骤

1. 创建学生类

```java
@Data
@AllArgsConstructor
public class Student {
    private int id;
    private String name;
    private float score;
}
```



2. 创建maven工程, pom.xml导入依赖

```xml
<!-- 配置java版本 -->
<properties>
    <java.version>13</java.version>
    <maven.compiler.source>${java.version}</maven.compiler.source>
    <maven.compiler.target>${java.version}</maven.compiler.target>
</properties>

<!-- 本项目位置 -->
<groupId>com.guxiyuesi</groupId>
<artifactId>test</artifactId>
<version>1.0-SNAPSHOT</version>

<dependencies>
    <!-- springIoC依赖 -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.3.0</version>
    </dependency>

    <!-- lombok依赖, 可以自动生成实体类所需要的get, set等方法 -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.22</version>
        <scope>provided</scope>
    </dependency>

</dependencies>
```

3. 在resources下创建`spring.xml` , 加载`Student`类的实体bean

```xml
<?xml
version="1.0" encoding="UTF-8"?>
<beans
       xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:p="http://www.springframework.org/schema/p"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans-3.2.xsd
                           http://www.springframework.org/schema/context
                           http://www.springframework.org/schema/context/spring-context-4.3.xsd"
>
	<bean id="student" class="com.southwind.entity.Student"></bean>
</beans>
```

4. 在主类中获取到`spring.xml` 配置的Student对象

```java
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = (Student)applicationContext.getBean("student");
        System.out.println(student);
    }
}
/**
Student(id=0, name=null, score=0.0)
*/
```



#### 1.1.2 IoC容器加载bean创建的对象的两种方式

1. 无参构造函数

```xml
<bean id="student" class="com.southwind.entity.Student"></bean>
```

​      配置属性名

```xml
<bean id="student" class="com.guxiyuesi.springIoC.Student">
    <property name="id" value="1"></property>
    <property name="name" value="mary"></property>
    <property name="score" value="18"></property>
</bean>
<!-- 主函数运行结果: Student(id=1, name=mary, score=18.0) -->
```

2. 有参构造函数

```xml
<!-- 可以使用name-value来给有参构造函数传值 -->
<bean id="student2" class="com.guxiyuesi.springIoC.Student">
    <constructor-arg name="id" value="2"></constructor-arg>
    <constructor-arg name="name" value="lisa"></constructor-arg>
    <constructor-arg name="score" value="77"></constructor-arg>
</bean>
<!-- 主函数运行结果: Student(id=2, name=lisa, score=77.0) -->
```

```xml
<!-- 也可以不指定参数, 直接赋值, 则赋值的顺序必须按照构造函数参数的顺序从上往下赋值 -->
<bean id="student2" class="com.guxiyuesi.springIoC.Student">
    <constructor-arg value="2"></constructor-arg>
    <constructor-arg value="lisa"></constructor-arg>
    <constructor-arg value="77"></constructor-arg>
</bean>
```

```xml
<!-- 也可以使用下标指定赋值的参数的位置, 效果与name-value一致 -->
<bean id="student2" class="com.guxiyuesi.springIoC.Student">
    <constructor-arg index="0" value="2"></constructor-arg>
    <constructor-arg index="1" value="lisa"></constructor-arg>
    <constructor-arg index="2" value="77"></constructor-arg>
</bean>
```

#### 1.1.3 从IoC容器中取bean

1. 通过id取值

```java
ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//id值不能重复
Student student = (Student)applicationContext.getBean("student2");
```

2. 通过类型取值

```java
ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//spring.xml中只配置一个Student的bean对象时, 可以使用这种方法
Student student = (Student)applicationContext.getBean(Student.class);
```

#### 1.1.4 bean对象中包含特殊字符

```xml
<!-- 使用<![CDATA[ 内容 ]]> 来标识文本-->
<bean id="student2" class="com.guxiyuesi.springIoC.Student">
	<constructor-arg index="0" value="2"></constructor-arg>
	<constructor-arg name="name">
		<value> <![CDATA[ <lisa> ]]> </value>
	</constructor-arg>
	<constructor-arg name="score" value="77"></constructor-arg>
</bean>
```

#### 1.1.5 DI

DI是用来配置级联对象的值

1. 创建实体类   每一个Student对象都有一个对应的班级

```java
//Student类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private TheClass theClass;
}
```

```java
//TheClass类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheClass {
    private int classId;
    private String className;
}
```

2. 在Spring-di.xml中配置Student类的对象, 通过ref属性实现对学生对象中 theClass属性 赋值

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans
        xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:p="http://www.springframework.org/schema/p"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans-3.2.xsd
                           http://www.springframework.org/schema/context
                           http://www.springframework.org/schema/context/spring-context-4.3.xsd">

    <!-- p命令空间, 是用来简化配置的 -->
    <bean id="class1" class="com.guxiyuesi.springIoC.TheClass" p:classId="1" p:className="1班"></bean>
    <bean id="student1" class="com.guxiyuesi.springIoC.Student" p:id="1" p:name="mary" p:theClass-ref="class1"></bean>
    <bean id="student2" class="com.guxiyuesi.springIoC.Student" >
        <property name="id" value="2"></property>
        <property name="name" value="lisa"></property>
        <property name="theClass" ref="class1"></property>
    </bean>
</beans>
```

3. 主类

```java
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-di.xml");
        Student student1 = (Student)applicationContext.getBean("student1");
        Student student2 = (Student)applicationContext.getBean("student2");
        System.out.println(student1);
        System.out.println(student2);
    }
}
/*
输出结果:
Student(id=1, name=mary, theClass=TheClass(classId=1, className=1班))
Student(id=2, name=lisa, theClass=TheClass(classId=1, className=1班))
*/
```



对象中集合属性的依赖注入

```java
//Student类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
}
```

```java
//TheClass类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheClass {
    private int classId;
    private String className;
    private Map<Integer, Student> studentMap;
}
```

在spring-di-map.xml中进行依赖注入

```xml
<bean id="student1" class="com.guxiyuesi.springIoC.Student" p:id="1" p:name="mary"></bean>
<bean id="student2" class="com.guxiyuesi.springIoC.Student" p:id="2" p:name="lisa"></bean>
<bean id="theClass" class="com.guxiyuesi.springIoC.TheClass">
    <property name="classId" value="1"></property>
    <property name="className" value="1班"></property>
    <property name="studentMap">
        <map>
            <entry key="1" value-ref="student1"></entry>
            <entry key="2" value-ref="student2"></entry>
        </map>
    </property>
</bean>
```

在主类中获取对象

```java
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-di-map.xml");
        TheClass theClass = (TheClass)applicationContext.getBean("theClass");
        System.out.println(theClass);
    }
}
/*
输出结果:
TheClass(classId=1, className=1班, studentMap={1=Student(id=1, name=mary), 2=Student(id=2, name=lisa)})
*/
```



#### 1.1.6 bean的作用域

bean是根据scope来⽣成，表示bean的作⽤域，scope有4种类型：

+ singleton，单例，表示通过Spring容器获取的对象是唯⼀的，默认值。
+ prototype，原型，表示通过Spring容器获取的对象是不同的。
+ request，请求，表示在⼀次HTTP请求内有效。
+ session，会话，表示在⼀个⽤户会话内有效。

requset，session适⽤于Web项⽬。

singleton模式下，只要加载IoC容器，⽆论是否从IoC中取出bean，配置⽂件中的bean都会被创建。

prototype模式下，如果不从IoC中取bean，则不创建对象，取⼀次bean，就会创建⼀个对象。

```xml
<!-- 配置两个模式下的Student的bean对象 -->
<bean id="student1" class="com.guxiyuesi.springIoC.Student" p:id="1" p:name="mary" scope="singleton"></bean>
<bean id="student2" class="com.guxiyuesi.springIoC.Student" p:id="2" p:name="lisa" scope="prototype"></bean>
```

```java
//主类
Student student1_1 =(Student) applicationContext.getBean("student1");
Student student1_2 = (Student) applicationContext.getBean("student1");
Student student2_1 = (Student) applicationContext.getBean("student2");
Student student2_2 = (Student) applicationContext.getBean("student2");
System.out.println(student1_1 == student1_2);			//true
System.out.println(student2_1 == student2_2);			//false
```

#### 1.1.7 Spring中的继承

spring的继承是`面向值`的, 而不是面向对象的, 子bean可以继承父bean对应的值, 也可以覆盖父bean的值

```xml
<!-- 在spring-parent.xml中配置具有继承关系的两个bean -->
<bean id="student1" class="com.guxiyuesi.springIoC.Student" p:id="1" p:name="Mary"></bean>
<bean id="student2" class="com.guxiyuesi.springIoC.Student" parent="student1" p:id="2"></bean>
```

主类中输出类

```java
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-parent.xml");
        Student student1 = (Student)applicationContext.getBean("student1");
        Student student2 = (Student) applicationContext.getBean("student2");
        System.out.println(student1);
        System.out.println(student2);
    }
}
/*
输出结果:
Student(id=1, name=Mary)
Student(id=2, name=Mary)
*/
```



即使不是同一个类, 只要子bean中的类的属性包含父bean中类的属性, 也可以继承值

```java
//Car类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private int id;
    private String name;
    private String brand;
}
```

```xml
<bean id="student1" class="com.guxiyuesi.springIoC.Student" p:id="1" p:name="Mary"></bean>
<bean id="car" class="com.guxiyuesi.springIoC.Car" parent="student1"></bean>
```

主类

```java
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-parent.xml");
        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car);
    }
}
/*
输出结果:
Car(id=1, name=Mary, brand=null)
*/
```

#### 1.1.8 Spring读取外部资源

实际开发中，数据库的配置⼀般会单独保存到后缀为properties的⽂件中，⽅便维护和修改.

如果使⽤Spring来加载数据源，就需要在spring.xml中读取properties中的数据，这就是读取外部资源.

1. 使用maven配置mysql驱动包

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.18</version>
</dependency>
```

2. 配置`jdbc.properties`

```properties
user = root
password = 339558
url = jdbc:mysql://localhost:3306/mytest?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC
driverName = com.mysql.cj.jdbc.Driver
```

3. 使用 `GetDataBase` 存储连接数据库需要的信息

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetDataBase {
    private String user;
    private String password;
    private String url;
    private String driverName;
}
```

4. 通过`spring-properties.xml` 加载外部信息

```xml
<!-- 加载外部资源 -->
<context:property-placeholder location="classpath:jdbc.properties"></context:property-placeholder>
<!-- 使用SpEL语法赋值 -->
<bean id="database" class="com.guxiyuesi.springIoC.GetDataBase"
      p:user="${user}" p:password="${password}" p:url="${url}" p:driverName="${driverName}">
</bean>
```

5. 在主类中连接数据库

```java
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-properties.xml");
        GetDataBase database = (GetDataBase) applicationContext.getBean("database");
        try {
            //1. 加载数据库驱动
            Class.forName(database.getDriverName());
            //2. 获取数据库连接
            Connection connection = DriverManager.getConnection(database.getUrl(), database.getUser(), database.getPassword());
            //3. 创建执行数据库命令的对象
            PreparedStatement preparedStatement = connection.prepareStatement("select * from first");
            //4. 执行命令并返回结果集
            ResultSet resultSet = preparedStatement.executeQuery();
            //5. 遍历结果集
            while (resultSet.next()) {
                String myUsername = resultSet.getString("username");
                String myPassword = resultSet.getString("password");
                System.out.println(myUsername + "  " + myPassword);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
/*
输出结果:
abc  111
efg  222
hig  333
mary  123
lisa  456
*/
```



#### 1.1.9 Autowire  自动装载

自动装载相当于自动化的DI, 可以从IoC容器中自动取出对应的对象进行注入

查找的方式有两种:

+ `byName` 
  查找 id名 和 需要注入的属性名相同的bean对象, 并将该对象注入
+ ![image-20211020200230686](https://gitee.com/four_four/picgo/raw/master/img/20211020200230.png) 

+ `byType` 
  根据类型进行自动装载
  此时配置的对应的bean对象只能有一个
  ![image-20211020200554341](https://gitee.com/four_four/picgo/raw/master/img/20211020200554.png) 

```java
//Car类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private int id;
    private String name;
    private String brand;
}
```

```java
//Person类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int id;
    private String name;
    private Car car2;
}
```

```xml
<!-- 
自动装载的方式: byName
通过IoC容器获取到Person对象后输出结果为:
Person(id=339558, name=张三, car2=Car(id=2, name=二手, brand=宝马))
-->

<bean id="car" class="com.guxiyuesi.springIoC.Car">
    <property name="name" value="新品"></property>
    <property name="id" value="1"></property>
    <property name="brand" value="奔驰"></property>
</bean>

<bean id="car2" class="com.guxiyuesi.springIoC.Car">
    <property name="name" value="二手"></property>
    <property name="id" value="2"></property>
    <property name="brand" value="宝马"></property>
</bean>

<bean id="person" class="com.guxiyuesi.springIoC.Person" autowire="byName">
    <property name="id" value="339558"></property>
    <property name="name" value="张三"></property>
</bean>
```

```xml
<!-- 
通过byType进行装载
输出person:
Person(id=339558, name=张三, car2=Car(id=1, name=新品, brand=奔驰))
-->
<bean id="car" class="com.guxiyuesi.springIoC.Car">
    <property name="name" value="新品"></property>
    <property name="id" value="1"></property>
    <property name="brand" value="奔驰"></property>
</bean>

<bean id="person" class="com.guxiyuesi.springIoC.Person" autowire="byType">
    <property name="id" value="339558"></property>
    <property name="name" value="张三"></property>
</bean>
```



#### 1.1.10 Spring IoC基于注解开发

Spring IoC的作用:

+ 创建项目中所需要的bean
+ 完成bean之间的依赖注入

实现IoC功能的两种方式:

1. 基于XML配置
2. 基于注解配置

基于注解配置的两个步骤

1. 配置自动扫包

   ```xml
   <context:component-scan base-package="com.iocAnnotation"></context:component-scan>
   ```

2. 添加注解

   ```java
   @Data
   @Component(value = "myScore")
   public class Score {
       @Value("78.0")
       private float englishScore;
       @Value("88.5")
       private float mathScore;
   }
   ```

   

> 使用注解生成bean

```java
@Data
@Component(value = "myScore")
public class Score {
    @Value("78.0")
    private float englishScore;
    @Value("88.5")
    private float mathScore;
}
```

等价于

```xml
<bean id="myScore" class="com.iocAnnotation.Score">
	<property name="englishScore" value="78.0">	           </property>
    <property name="mathScore" value="88.5">               </property>
</bean>
```

`@Component`    相当于生成bean对象, 可以在bean对象中指定id的值

`@Value`  相当于给变量赋值



> DI

```java
@Data
@Component
public class Student {
    @Value("1")
    private int id;
    @Value("张三")
    private String name;
    @Autowired
    @Qualifier(value = "myScore")
    private Score score;
}
```

等价于

```xml
<bean id="student" class="com.iocAnnotation.Student">
	<property name="id" value="1"></property>
    <property name="name" value="张三"></property>
    <property name="score" ref="myScore"></property>
</bean>
```

注解完成DI的方式是使用自动装载

`@Autowired`    通过 ==byType== 的方式进行自动装载

`@Qualifier`    通过 ==byName== 的方式进行自动装载



#### 1.1.11 模拟基于注解进行开发

软件三层模型:

![image-20211021190442253](https://gitee.com/four_four/picgo/raw/master/img/20211021190442.png) 

==Controller== : 负责与客户端交互

==Service== : 负责处理业务逻辑

==Repository== : 负责与数据库交互

模拟从客户端输入姓名, 经过三层架构后返回是否成绩的等级(优秀/及格/不及格)

```java
//Controller
@Controller
public class MyController {
    @Autowired
    private MyService myService;

    //将客户端传来的数据传入到业务层
    public String service(String name) {
        return myService.getGrade(name);
    }

	//main函数等价于客户端
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-grade.xml");
        MyController myController = applicationContext.getBean(MyController.class);
        System.out.println(myController.service("李四"));
    }
}
```

```java
//Service
@Service
public class MyService {
    @Autowired
    private MyRepository myRepository;

    //接收到Controller后, 向Repository层调用数据, 并对Repository层返回的数据进行处理
    public String getGrade(String name){
        Double score = myRepository.getScore(name);
        String grade = "";
        if(score < 60) {
            grade = "不及格";
        }
        else if (score < 80) {
            grade = "及格";
        } else {
            grade = "优秀";
        }
        return grade;
    }
}
```

```java
@Repository
public class MyRepository {
    //用Map模拟数据库中的数据
    private Map<String, Double> score;
    MyRepository() {
        score = new HashMap<>();
        score.put("张三", 61.0);
        score.put("李四", 73.4);
    }

    //接收到Service层传来的name后, 查找数据并返回
    public Double getScore(String name) {
        return score.get(name);
    }
}
```





### 1.2 AOP

AOP(Aspect Oriented Programming)  面向切面编程

AOP是OOP的补充, 具体是指程序运行时, **动态**的将非业务代码切入到业务代码中, 从而实现程序的解耦合，将业务代码抽象成一个对象, 对该切面对象编程就是面向切面编程.

