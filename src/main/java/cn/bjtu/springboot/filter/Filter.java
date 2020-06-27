package cn.bjtu.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author chancey
 * @create 2020-04-27 23:14
 */
public class Filter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter执行了");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
