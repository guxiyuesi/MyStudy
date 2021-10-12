package c3p02;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 叶意
 * @ClassName Main
 * @Description 通过xml文件配置数据库连接池
 * @createTime 2021年10月12日  17:15:00
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource("testc3p0");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
