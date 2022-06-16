package cn.agree.test;

import java.sql.*;

public class JDBCUtils {
    // 1.将固定字符串定义为常量
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String URL="jdbc:mysql:///db1";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // 2.静态代码块中注册驱动
    static {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 3.提供一个获取连接的方法
    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }

    // 4.定义关闭资源的方法close
    public static void close(Connection connection, Statement stmt, ResultSet rs) {
        if (rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 5.重载关闭方法
    public static void close(Connection connection, Statement stmt) {
        close(connection, stmt, null);
    }


}
