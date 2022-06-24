package cn.agree.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "CookieServlet1", urlPatterns = "/cookie1")
public class CookieServlet1 extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("username", "tom");
        // 设置cookie的路径-浏览器根据这个路径判断哪些cookie要发给服务器

        // cookie 是不能存放 空格 ; , 如果一定要存放就ENcode/Decode一下
        // URLEncoder.encode()

        cookie.setPath("/cookie2");
        // 把cookie发送给浏览器
        resp.addCookie(cookie);

    }

}
