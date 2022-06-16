package cn.agree.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C3P0Demo01 {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource ds = new ComboPooledDataSource();

       /* for (int i=0; i<12; i++) {
            Connection connection = ds.getConnection();
            System.out.println(connection);
        }*/

        Connection connection = ds.getConnection();
        String sql = "select * from employee where id < ?;";
        PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setInt(1, 9);

        ResultSet resultSet = pstmt.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            System.out.println(name);
        }

        pstmt.close();
        connection.close();

    }
}
