package cn.agree.metadata;

import cn.agree.utils.DruidUtils;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MetaDemo01 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DruidUtils.getConnection();
        // System.out.println(conn);

        String sql = "select * from employee where id < ?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        // pstmt.setInt(1, 10);

        // 参数元数据
        ParameterMetaData parameterMetaData = pstmt.getParameterMetaData();
        // 一共有几个参数
        int count = parameterMetaData.getParameterCount();
        System.out.println(count);

        for (int i=1; i<=count; i++) {
            // 该方法并不是所有数据库都支持 --- MySQL不支持（所有返回类型都是varchar）
            // int type = parameterMetaData.getParameterType(i);
            // System.out.println(type);
            System.out.println(parameterMetaData.getParameterTypeName(i));
        }


    }
}
