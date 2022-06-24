package cn.agree.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SessionServlet02", urlPatterns = "/session02")
public class SessionServlet02 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println("获取的session对象:"+session);
        // 获取数据
        String addr = (String) session.getAttribute("addr");
        System.out.println(addr);

        // 移除数据
     /*   session.removeAttribute("addr");
        String addr1 = (String) session.getAttribute("addr");
        System.out.println(addr1);*/

    }
}
