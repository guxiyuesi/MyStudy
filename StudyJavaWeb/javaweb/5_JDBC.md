# JDBC

## 1. JDBC简介

java DataBase Connectivity 是一个独立于特定数据库的管理系统, 通用的SQL数据库存取和操作的公共接口.

定义了一组标准, 为访问不同数据库提供了统一的途径.

![image-20211010201041661](https://gitee.com/four_four/picgo/raw/master/img/20211010201048.png) 

### 1.1 JDBC的体系结构

JDBC接口包括两个层面:

+ 面向应用的API, 供程序员调用
+ 面向数据库的API, 供厂商开发数据库的驱动程序

> JDBC API

+ 提供者: java官方
+ 内容 : 供开发者调用的接口
  `java.sql`  和 `javax.sql` 
  主要类/接口:
  + `DriverManager`类
  + `Connection`接口
  + `Statement`接口
  + `ResultSet`接口

> DriverManager

提供者: java官方

作用: 管理不同的JDBC驱动

> JDBC驱动

提供者: 数据库厂商

作用: 负责连接不同的数据库



### 1.2 JDBC的使用

1. 加载数据库驱动, 相当于让程序识别是使用哪一种数据库
2. 获取Connection, 是java与数据库的一次连接
3. 创建Statement对象, 由Connection产生, 用于执行SQL语句
4. 如果需要接受返回值, 创建ResultSet对象, 保存Statement执行之后所查询到的结果

即: 识别 -> 连接 -> 执行SQL -> 接受返回值

```java
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            //加载驱动 通过反射加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接    端口后的是使用的数据库名
            String url = "jdbc:mysql://localhost:3306/mytest?useUnicode=true" +
                    "&characterEncoding=UTF-8&serverTimezone=UTC";
            String user = "root";
            String password = "339558";
            Connection connection = DriverManager.getConnection(url, user, password);
            //获取执行sql的Statement类的对象
            Statement statement = connection.createStatement();
            //执行sql   查询使用executeQuery方法, 其他使用execute方法
            //使用ResultSet接收查询结果
            String sql = "select * from first";
            ResultSet resultSet = statement.executeQuery(sql);
            //遍历结果集
            while(resultSet.next()) {
                String myUsername = resultSet.getString("username");
                String myPassword = resultSet.getString("password");
                System.out.println(myUsername + "  " + myPassword);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```



### 1.3 PreparedStatement类

Statement的子类, 提供了SQL占位符的功能

解决了使用Statement进行开发的两个问题:

1. 需要平凡拼接字符串, 出错了较高
2. 存在SQL注入风险

```java
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            //加载驱动 通过反射加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接    端口后的是使用的数据库名
            String url = "jdbc:mysql://localhost:3306/mytest?useUnicode=true" +
                    "&characterEncoding=UTF-8&serverTimezone=UTC";
            String user = "root";
            String password = "339558";
            Connection connection = DriverManager.getConnection(url, user, password);
            //需要执行的sql语句, 使用占位符

            //String sql = "select * from first where username = ? and password = ?";
            String sql = "select * from first";
            //创建PreparedStatement 对象,与Statement不同的是, 需要传入要执行的sql语句
            PreparedStatement preparedStatement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //向占位符中传递值 第一个参数是位置, 第二个参数是值

//            preparedStatement.setString(1, "abc");
//            preparedStatement.setString(2, "111");
            ResultSet resultSet = preparedStatement.executeQuery();
            //遍历结果集
            Thread.sleep(5000);
            while(resultSet.next()) {
                String myUsername = resultSet.getString("username");
                String myPassword = resultSet.getString("password");
                System.out.println(myUsername + "  " + myPassword);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

+ `ResultSet.TYPE_SCROLL_SENSITIVE`
  结果设定为可滚动的数据集, 底层数据的改变会影响结果集
  查询出来的结果并不是与数据库脱离的结果集, 而是符合条件的原始的==ROWID== , 通过数据库的底层定位==ROWID== 所在的行

  + 程序查询后如果有其他进程进行`Update`操作, 可以通过 ==ROWID== 获取到值, 但获取到的是 **更新后的值**
  + ~`Delete` 操作, 可以获取到 **被删除的值** 
  + ~`Insert`操作, 程序并未记录新的行的==ROWID== , 所以**无影响**   

  `ResultSet.TYPE_FORWARD_ONLY`， 只能向前移动

  `ResultSet.TYPE_SCROLL_INSENSITIVE`， 可滚动，但是底层数据的改变不会影响结果集

+ `ResultSet.CONCUR.UPDATABLE` 可更新的并发模式
  `ResultSet.CONCUR_READ_ONLY` 只读的并发模式





# 数据库连接池

## 1. 为什么需要数据库连接池

JDBC的执行流程:

1. 通过`DriverManager`验证用户名, 密码, 获取到数据库连接对象
2. 执行SQL语句
3. 断开连接, 数据库连接对象失效
4. 再次连接需要重新创建数据库的连接对象

这样每次查询都需要创建一个数据库连接对象, 每个数据库连接对象只是用一次, 浪费资源

数据库连接池的基本思想是: 

1. 为数据库建立一个缓冲池, ==预先== 向缓冲池中放入一定量的连接对象
2. 需要进行数据库连接时, 只需要从缓冲池中取出连接对象
3. 用完以后, 将连接对象放回缓冲池, 供下一次请求使用
4. 当数据库连接池中没有空闲的连接时, 新的请求就会进入等待队列, 等待其他线程释放连接

![image-20211012165322619](https://gitee.com/four_four/picgo/raw/master/img/20211012165329.png) 

## 2. 数据库连接池的实现

JDBC的数据库连接池使用`javax.sql.DataSource`接口完成的, DataSource是Java官方提供的接口.

C3P0是常用的第三方实现, 实际开发中常用它来完成数据库连接池的操作.

1. 导入jar包
   `C3P0-version.jar`
2. 创建一个数据库连接池
3. 连接数据库
4. 获取连接池中的连接对象
5. 执行SQL语句
6. 返还连接对象

```java
package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws PropertyVetoException, SQLException {
        //1. 创建数据库连接池
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //2. 加载驱动
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        //3. 获取连接对象
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mytest?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("339558");
        Connection connection = dataSource.getConnection();
        //4. 将连接对象放回连接池
        dataSource.close();
        
        //连接池的一些方法
        //初始化连接池大小
        dataSource.setInitialPoolSize(20);
        //设置连接池中最大的连接池数量
        dataSource.setMaxPoolSize(40);
        //设置连接池中连接对象数量的临界点
        //当只剩下2个连接对象时, 向数据库申请更多的连接对象
        dataSource.setMinPoolSize(2);
        //设置一次向数据库中申请连接对象的数量
        dataSource.setAcquireIncrement(5);
    }
}
```

实际开发中, 并不直接在代码中配置连接池的属性, 而是在配置文件中配置, 然后通过代码加载配置文件.

原因: 修改java代码后需要重新编译, 代价高; 但修改xml文件是没有代价的

使用xml配置连接池:

```xml
<!-- 配置连接池的文件名必须是c3p0-config.xml -->
<c3p0-config>
    <named-config name="testc3p0">

        <!-- 配置连接数据库的基本属性 -->
        <property name="user">root</property>
        <property name="password">339558</property>
        <property name="jdbcUrl">jdbc:mysql://localhost:3306/mytest?useUnicode=true&amp;characterEncoding=UTF-8&amp;serverTimezone=UTC</property>
        <property name="driverClass">com.mysql.cj.jdbc.Driver</property>
        <!-- 配置连接池属性 -->
        <property name="acquireIncrement">5</property>
        <property name="initialPoolSize">20</property>
        <property name="minPoolSize">2</property>
        <property name="maxPoolSize">40</property>
    </named-config>
</c3p0-config>
```

```java
//通过xml配置连接池属性
public class Main {
    public static void main(String[] args) throws SQLException {
        //有参构造传入的并不是xml文件的文件名, 而是named-config标签中配置的name
        ComboPooledDataSource dataSource = new ComboPooledDataSource("testc3p0");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
```

