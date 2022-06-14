package cn.agree.test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDemo01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 查看Driver的源码发现 Driver类已经注册了自己
        // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        // 类加载器 会这个类的静态代码块
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");

        System.out.println(connection);

    }
}
