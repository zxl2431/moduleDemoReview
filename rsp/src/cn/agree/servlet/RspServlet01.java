package cn.agree.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RspServlet01", urlPatterns = "/rsp01")
public class RspServlet01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 自动刷新操作 在3秒之后跳转京东主页
        // 给指定的名称和值设置响应头
        resp.setHeader("Refresh", " 3;url=http://www.jd.com");
        /*
        *  常见的响应头
        *
        * */
        // location: 重定向
        // content-encoding 当前数据的压缩格式
        // content-disposition 告诉浏览器弹出一个下载提示框
        // content-type 告诉客户端 响应数据类型 text/html;charset=utf-8


        // 设置响应吗
        resp.setStatus(200);

        // 重定向 setHeader("location", "http://www.taobao.com");
        resp.sendRedirect("http://www.taobao.com");
    }
}
