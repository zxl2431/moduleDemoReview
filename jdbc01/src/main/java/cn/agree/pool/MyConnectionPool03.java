package cn.agree.pool;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

public class MyConnectionPool03 implements DataSource {
    private LinkedList<Connection> pool = new LinkedList<>();
    private String url = "jdbc:mysql:///db1";
    private String user = "root";
    private String password="root";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public MyConnectionPool03(LinkedList<Connection> pool) throws SQLException {
        // 初始化的时候放5个连接进去
        for (int i=0; i<5; i++) {
            Connection connection = DriverManager.getConnection(url, user, password);
            MyConnection myConnection = new MyConnection(connection);
            pool.add(myConnection);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = null;
        if (pool.size() > 0) {
            connection = pool.removeFirst();
        } else {
            // 池子里面没有啦
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
