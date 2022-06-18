package cn.agree.template;

import cn.agree.pojo.Product;
import cn.agree.utils.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TemplateDemo02 {
    public static void main(String[] args) {
        /*
        * JdbcTemplate的查询 方法挺多
        *
        *  queryForObject()
        * */
        // test01();
        /*
        *  queryForMap()
        *
        * */
        // test02();
        /*
        *  queryForList()
        *
        * */
        // test03();

        /*
        *  query(sql, new RowMapper)
        * */
        // test04();

        /*
        *  query(sql, new BeanPropertyRowMapper<>(Product.class))
        * */
        test05();
    }

    /*
    *  queryForInt 返回一个整数
    *  queryForLong
    *  这两个方法已经没有了
    *  queryForObject 通用挺好
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

    /*
    *  queryForMap
    *
    * */
    public static void test02() {
        String sql = "select * from product where pid=?;";
        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
        Map<String, Object> map = template.queryForMap(sql, 6);
        System.out.println(map);
    }

    /*
    *  queryForList()
    *
    * */
    public static void test03() {
        String sql = "select * from product where pid<?;";
        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
        List<Map<String, Object>> maps = template.queryForList(sql, 8);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

    /*
    *
    *
    * */
    public static void test04() {
        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());

        String sql = "select * from product where pid < ?;";


        List<Product> list = template.query(sql, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product p = new Product();
                p.setPid(resultSet.getInt("pid"));
                p.setPname(resultSet.getString("pname"));
                p.setPrice(resultSet.getDouble("price"));
                return p;
            }
        }, 9);

        // template.query

        for (Product product : list) {
            System.out.println(product);
        }

    }

    /*
    *
    *
    * */
    public static void test05() {
        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "select * from product where pid <?";

        List<Product> list = template.query(sql, new BeanPropertyRowMapper<>(Product.class), 3);

        for (Product product : list) {
            System.out.println(product);
        }

    }


}
