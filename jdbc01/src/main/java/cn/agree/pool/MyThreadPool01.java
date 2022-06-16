package cn.agree.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class MyThreadPool01 {

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
    public MyThreadPool01(LinkedList<Connection> pool) throws SQLException {
        // 初始化的时候放5个连接进去
        for (int i=0; i<5; i++) {
            Connection connection = DriverManager.getConnection(url, user, password);
            pool.add(connection);
        }
    }

    // 获取连接 从池子里面拿
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

    public void addBack(Connection connection) {
        /*
        *  这里有个问题
        *  不是原来池子里面的连接也会被丢进池子里面
        *
        * */
        pool.addLast(connection);
    }




}
