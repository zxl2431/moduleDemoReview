package cn.agree.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ConServlet02", urlPatterns = "/con02")
public class ConServlet02 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取容器
        ServletContext context = getServletContext();
        // 获取参数
        String addr  = (String) context.getAttribute("addr");
        System.out.println("存入之后,获取数据:"+addr);
        context.removeAttribute("addr");
        addr = (String) context.getAttribute("addr");
        System.out.println("删除之后,获取数据:"+addr);
    }
}
