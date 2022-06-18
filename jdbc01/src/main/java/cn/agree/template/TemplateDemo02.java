package cn.agree.template;

import cn.agree.utils.DruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class TemplateDemo02 {
    public static void main(String[] args) {
        /*
        * JdbcTemplate的查询 方法挺多
        *
        * */
        test01();
    }

    /*
    *  queryForInt 返回一个整数
    *
    * */
    public static void test01() {
        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
        String sql_int = "select pid from product where price = 18888;";
        String sql_string = "select pname from product where price = 7777;";

        // 这两个方法已经不用了
        /* template.queryForInt(sql);
        template.queryForLong(sql);
        */

        Integer pid = template.queryForObject(sql_int, Integer.class);
        System.out.println(pid);
        String pname = template.queryForObject(sql_string, String.class);
        System.out.println(pname);


    }
}
