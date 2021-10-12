package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 叶意
 * @ClassName Main
 * @Description 学习数据库连接池
 * @createTime 2021年10月12日  16:56:00
 */
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
