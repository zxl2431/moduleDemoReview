package cn.agree.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCDemo04 {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "SELECT * from USER WHERE id=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setInt(1, 1);

        ResultSet resultSet = pstmt.executeQuery();

        while (resultSet.next()) {
            String username = resultSet.getString("username");

            System.out.println(username);
        }

        JDBCUtils.close(connection, pstmt, resultSet);
    }
}
