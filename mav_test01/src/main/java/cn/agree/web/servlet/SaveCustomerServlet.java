package cn.agree.web.servlet;

import cn.agree.pojo.Customer;
import cn.agree.service.CustomerServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "SaveCustomerServlet", urlPatterns = "/customer")
public class SaveCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        req.setCharacterEncoding("utf-8");
       /* String cust_name = req.getParameter("cust_name");
        String cust_source = req.getParameter("cust_source");
        String cust_level = req.getParameter("cust_level");
        String cust_industry = req.getParameter("cust_industry");
        String cust_phone = req.getParameter("cust_phone");
        String cust_mobile = req.getParameter("cust_mobile");

        //封装数据
        Customer customer = new Customer();
        customer.setCust_name(cust_name);
        customer.setCust_industry(cust_industry);
        customer.setCust_phone(cust_phone);
        customer.setCust_level(cust_level);
        customer.setCust_source(cust_source);
        customer.setCust_mobile(cust_mobile);*/

        Customer customer = new Customer();
        Map<String, String[]> map = req.getParameterMap();

        try {
            BeanUtils.populate(customer, map);
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("Servlet接受参数customer:"+customer);


        //调用业务
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        try {
            customerService.save(customer);
        }catch (Exception e) {
            resp.sendRedirect(req.getContextPath()+"/failed.html");
            e.printStackTrace();
        }


        //重定向
        resp.sendRedirect(req.getContextPath()+"/success.html");


    }
}
