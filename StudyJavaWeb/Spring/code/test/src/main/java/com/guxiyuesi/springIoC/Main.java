package com.guxiyuesi.springIoC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author 叶意
 * @ClassName Main
 * @Description TODO
 * @createTime 2021年10月16日  17:31:00
 */
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
