package cn.agree.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DruidDemo01 {
    public static void main(String[] args) throws Exception {
        // 加载配置文件
        InputStream is = DruidDemo01.class.getResourceAsStream("/druid.properties");
        Properties pp = new Properties();
        pp.load(is);

        // System.out.println(pp);

        DataSource ds = DruidDataSourceFactory.createDataSource(pp);

        Connection connection = ds.getConnection();
        String sql = "select * from employee where id<?";
        PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setInt(1, 10);
        ResultSet resultSet = pstmt.executeQuery();

        pstmt.executeQuery(sql);

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");

            System.out.println(name+"---"+age);
        }


    }
}
