package cn.agree.template;

import cn.agree.utils.DruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class TemplateDemo01 {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());

        // 建表
        // createTable(jdbcTemplate);

        // 插入数据
        // test01(jdbcTemplate);

        // 修改数据
        // test02(jdbcTemplate);

        // 删除数据
        test03(jdbcTemplate);

    }

    public static void createTable(JdbcTemplate template) {
        String sql = "create table product("
                + "pid int primary key auto_increment,"
                + "pname varchar(20),"
                + "price double"
                + ");";

        template.execute(sql);

    }

    /*
    *  添加数据
    *
    *
    * */
    public static void test01(JdbcTemplate template) {
        String sql = "insert into product values (null, ?,?);";

        template.update(sql, "iPhone3GS", 3333);
        template.update(sql, "iPhone4", 5000);
        template.update(sql, "iPhone4S", 5001);
        template.update(sql, "iPhone5", 5555);
        template.update(sql, "iPhone5C", 3888);
        template.update(sql, "iPhone5S", 5666);
        template.update(sql, "iPhone6", 6666);
        template.update(sql, "iPhone6S", 7000);
        template.update(sql, "iPhone6SP", 7777);
        template.update(sql, "iPhoneX", 8888);
    }

    /*
    *  修改数据
    *
    * */
    public static void test02(JdbcTemplate template) {
        String sql = "update product set pname=?, price=? where pid =?;";

        int i = template.update(sql, "XVIII", 18888, 10);
        System.out.println("影响的行数:"+i);

    }

    /*
    *  删除数据
    *
    * */
    public static void test03(JdbcTemplate template) {
        String sql = "delete from product where pid=?;";

        int i = template.update(sql, 7);
        System.out.println("影响的行数:"+i);
    }



}
