package cn.agree.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "FiltereDemo03", urlPatterns = "/*",
        dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class FiltereDemo03 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FiltereDemo03初始化了...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FiltereDemo03的doFilter执行了...");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("FilterDemo03销毁了...");
    }
}
