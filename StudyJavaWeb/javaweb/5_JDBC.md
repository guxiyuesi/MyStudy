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