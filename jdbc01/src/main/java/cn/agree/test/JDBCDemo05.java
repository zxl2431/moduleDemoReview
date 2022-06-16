package cn.agree.test;

import cn.agree.pojo.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JDBCDemo05 {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from employee where id<?;";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, 6);
        ResultSet resultSet = pstmt.executeQuery();

        ArrayList<Employee> list = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String address = resultSet.getString("address");

            Employee employee = new Employee(id, name, age, address);
            list.add(employee);
        }

        for (Employee e: list) {
            System.out.println(e);
        }

        JDBCUtils.close(connection, pstmt, resultSet);


    }
}
