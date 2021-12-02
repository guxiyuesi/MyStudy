package jdbc;

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