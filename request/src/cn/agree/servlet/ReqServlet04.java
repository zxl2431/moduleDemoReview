package cn.agree.servlet;

import cn.agree.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReqServlet04", urlPatterns = "/req04")
public class ReqServlet04 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("对login请求的第二次处理");
        // 获取项目路径
        System.out.println("项目路径contextPath:"+ req.getContextPath());

        /*
        *  作为域对象的使用
        *  setAttribute(key)
        *  getAttribute(key)
        *  removeAttribute(key)
        *
        * */
        req.setAttribute("age", 18);
        System.out.println(req.getAttribute("age"));


        User user = (User) req.getAttribute("user");
        System.out.println(user);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("成功收到");


    }
}
