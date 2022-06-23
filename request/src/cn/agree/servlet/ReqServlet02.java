package cn.agree.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "ReqServlet02", urlPatterns = "/req02")
public class ReqServlet02 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        *  1. 根据name属性 获取对应的值
        *
        * */
        String username = req.getParameter("username");
        System.out.println(username);

        /*
        *  2. 获取复选框的值
        *
        * */
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby: hobbies) {
            System.out.println(hobby);
        }

        /*
        *  key作为参数 value作为值 封装到map中
        *
        * */
        Map<String, String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {
            for (String s : map.get(key)) {
                System.out.println(s);
            }
        }
    }
}
