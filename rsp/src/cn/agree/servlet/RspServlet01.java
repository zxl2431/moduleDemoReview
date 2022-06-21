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
        resp.setHeader("Refresh", " 3;url=http://www.jd.com");
        // 设置响应吗
        resp.setStatus(200);
    }
}
