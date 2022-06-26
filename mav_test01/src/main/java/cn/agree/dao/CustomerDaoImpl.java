package cn.agree.dao;

import cn.agree.dao.inter.CustomerDao;
import cn.agree.pojo.Customer;
import cn.agree.utils.JdbcUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerDaoImpl implements CustomerDao {

    JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public void save(Customer customer) {
        String sql = "insert into cst_customer(cust_name,cust_source,cust_industry,cust_level,cust_phone, cust_mobile)  " +
                "values(?,?,?,?,?,?)";

        // 执行查询操作
        jdbcTemplate.update(
                sql,
                customer.getCust_name(),
                customer.getCust_source(),
                customer.getCust_industry(),
                customer.getCust_level(),
                customer.getCust_phone(),
                customer.getCust_mobile()
        );
    }


}
