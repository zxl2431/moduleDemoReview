package cn.agree.servlet;

import cn.agree.utils.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "SessionServlet01", urlPatterns = "/session01")
public class SessionServlet01 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println(session);

        Cookie cookie = CookieUtil.createCookie("JSESSIONID", session.getId(), 1000, "session02");
        session.setAttribute("addr", "广州");
        resp.addCookie(cookie);

    }

}
