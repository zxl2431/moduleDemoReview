package cn.agree.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "ReqServlet01", urlPatterns = "/req01")
public class ReqServlet01 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        *  1 String getMethod()
        *  获取请求方式
        *
        * */
        String method = req.getMethod();
        System.out.println("获取请求方式的类型:"+method);

        /*
        *  getRequestURI()
        *  获取请求行中的资源名部分
        *
        * */
        System.out.println("请求行中的资源名部分:"+req.getRequestURI());

        /*
        * 获取完整的URL()
        *
        * */
        System.out.println("请求的完整URL:"+req.getRequestURL());

        /*
        *  获取当前协议的名称和版本
        *
        * */
        System.out.println("获取当前协议的名称和版本:"+ req.getProtocol());

        /*
        *  获取IP地址
        *
        * */
        System.out.println("获取IP地址:"+ req.getRemoteAddr());

        /*
        *  获取请求头信息
        *  getHeader()
        *
        * */
        System.out.println("获取请求头User-Agent:"+req.getHeader("User-Agent"));
        System.out.println("获取请求头referer:"+req.getHeader("referer"));
        System.out.println("-------------------");

        /*
        *  获取请求中包含所有头名称的枚举
        *
        * */
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            System.out.println("getHeaderNames:"+headerNames.nextElement());
        }

    }
}
