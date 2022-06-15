package cn.agree.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo02 {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");

            // 开启事务
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            //
            String sql = "UPDATE account SET balance = balance - 50 WHERE id=1;";
            statement.executeUpdate(sql);
            // 模拟异常
            // int i= 10/0;
            sql = "UPDATE account set balance = balance + 50 where id=2;";
            statement.executeUpdate(sql);

            statement.close();
            // 成功提交事务
            System.out.println("成功, 提交事务");
            connection.commit();

        } catch (Exception e) {
            // 失败
            try {
                System.out.println("出了异常,回滚");
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
