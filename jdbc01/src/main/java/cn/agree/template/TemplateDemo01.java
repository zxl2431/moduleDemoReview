package cn.agree.template;

import cn.agree.utils.DruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class TemplateDemo01 {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());

        createTable(jdbcTemplate);

    }

    public static void createTable(JdbcTemplate template) {
        String sql = "create table product("
                + "pid int primary key auto_increment,"
                + "pname varchar(20),"
                + "price double"
                + ");";

        template.execute(sql);

    }

}
