package cn.agree.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class MyConnectPool02 {
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

    // 构造方法
    public MyConnectPool02(LinkedList<Connection> pool) throws SQLException {
        // 初始化的时候放5个连接进去
        for (int i=0; i<5; i++) {
            Connection connection = DriverManager.getConnection(url, user, password);
            MyConnection myConnection = new MyConnection(connection);
            pool.add(myConnection);
        }
    }

    // 获取连接
    public Connection getConnectionFromPool() throws SQLException {
        Connection connection = null;
        if (pool.size() > 0) {
            connection = pool.removeFirst();
        } else {
            // 池子里面没有啦
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }

    public int getCount() {
        return pool.size();
    }

    // 归还连接
    public void addBack(Connection connection) throws SQLException {
        // 原来是池子里面的 MyConnection 就放到池子里面去
        if (connection instanceof MyConnection) {
            pool.addLast(connection);
        } else {
            connection.close();
        }
    }



}
