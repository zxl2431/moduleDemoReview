package cn.agree.service;

import cn.agree.dao.CustomerDaoImpl;
import cn.agree.dao.inter.CustomerDao;
import cn.agree.pojo.Customer;
import cn.agree.service.inter.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    CustomerDao customerDao = new CustomerDaoImpl();


    @Override
    public void save(Customer customer) {

        customerDao.save(customer);
    }
}
