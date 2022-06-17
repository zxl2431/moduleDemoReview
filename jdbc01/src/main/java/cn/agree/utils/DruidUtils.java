package cn.agree.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidUtils {
    //
    private static DataSource ds;

    static {
        InputStream is = DruidUtils.class.getResourceAsStream("/druid.properties");
        Properties pp = new Properties();
        try {
            pp.load(is);
            ds = DruidDataSourceFactory.createDataSource(pp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取数据源的方法
    public static DataSource getDataSource() {
        return ds;
    }

    // 获取连接对象的方法
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    //关闭资源的方法
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
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

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    //
    public static void close(Connection conn, Statement stmt) {
        close(conn, stmt, null);
    }


}
