package cn.agree.test;

import java.sql.*;

public class JDBCDemo01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 查看Driver的源码发现 Driver类已经注册了自己
        // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        // 类加载器 会这个类的静态代码块
        Class.forName("com.mysql.jdbc.Driver");

        // 获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
        System.out.println(connection);

        // 获取Statement对象
        Statement statement = connection.createStatement();

        /*// 插入表
        String sql = "insert into category (cname) values ('手机');";
        int i = statement.executeUpdate(sql);

        System.out.println("影响行数:"+i);*/

        queryCategory(statement);

    }

    public static void queryCategory(Statement statement) throws SQLException {
        String sql = "select * from category;";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int cid = resultSet.getInt("cid");
            String cname = resultSet.getString("cname");
            System.out.println(cid + "=="+cname);
        }

    }
}
