package cn.agree.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo03 {
    public static void main(String[] args) throws SQLException {
        // createTable();
        selectTable();
    }

    // 创建表
    public static void createTable() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        System.out.println(connection);

    }

    // 查询表
    public static void selectTable() throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        Statement statement = connection.createStatement();

        String sql = "select * from employee";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String address = resultSet.getString("address");

            System.out.println(id+"--"+name+"--"+age+"--"+address);
        }
    }


}
