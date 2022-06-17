package cn.agree.metadata;

import cn.agree.utils.DruidUtils;

import java.sql.*;

public class RSMetaData {
    public static void main(String[] args) throws SQLException {
        Connection connection = DruidUtils.getConnection();
        String sql = "select * from employee;";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet resultSet = pstmt.executeQuery();

        // 获取结果集的元数据
        ResultSetMetaData metaData = resultSet.getMetaData();
        int count = metaData.getColumnCount();

        // 打印第一行 表头
        for (int i=1; i<=count; i++) {
            System.out.println(metaData.getColumnName(i) + "\t");
        }
        System.out.println();

        // 打印每列类型
        for (int i=1; i<=count; i++) {
            System.out.println(metaData.getColumnTypeName(i)+"\t");
        }
        System.out.println();

        // 打印数据
        while (resultSet.next()) {
            for (int i=1; i<=count; i++) {
                System.out.println(resultSet.getObject(i)+"\t");
            }
            System.out.println();
        }





    }
}
