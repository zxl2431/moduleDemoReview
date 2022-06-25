package cn.agree.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "IllegalFilter", urlPatterns = "/IllegalFilter")
public class IllegalFilter implements Filter {

    // 声明一个集合用来保存非法字符
    private List<String> illegalWordsList = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 获取非法字符文件的绝对路径
        String path = filterConfig.getServletContext().getRealPath("/WEB-INF/classes/IllegalWords.txt");

        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(path), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = null;

            while ((line = br.readLine())!= null) {
                illegalWordsList.add(line);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.setContentType("text/html;charset=utf-8");
        // 获取请求中的参数
        String message = request.getParameter("message");

        //遍历所有的非法字符，对用户发表的言论进行校验
        for (String word:illegalWordsList){
            System.out.println(message+":"+word+"====索引："+message.indexOf(word));
            if((message.indexOf(word))!=-1){
                response.getWriter().write("含有非法字符，请重新发表言论");
                return;
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}
