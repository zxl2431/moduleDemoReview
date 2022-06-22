package cn.agree.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

@WebServlet(name = "ConServlet03", urlPatterns = "/con03")
public class ConServlet03 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Properties properties = new Properties();

        ServletContext context = getServletContext();

        // 发布后的相对路径是知道的
        String realPath = context.getRealPath("/WEB-INF/classes/druid.properties");
        System.out.println(realPath);

        // 绝对路径了
        FileInputStream isStream = new FileInputStream(realPath);
        properties.load(isStream);
        System.out.println(properties);

        System.out.println("-------------------------");

        String realPath1 = context.getRealPath("druid01.properties");
        System.out.println(realPath1);

        // 在resource中的文件 发布后会在WEB-INF/classes中
        // InputStream resourceAsStream = ConServlet03.class.getResourceAsStream(realPath);

        // context的getResourceAsStream() 默认只能获取到项目根路径
        InputStream resourceAsStream1 = context.getResourceAsStream("druid01.properties");

        Properties properties1 = new Properties();

        InputStreamReader reader = new InputStreamReader(resourceAsStream1, "UTF-8");
        properties.load(reader);




    }
}
