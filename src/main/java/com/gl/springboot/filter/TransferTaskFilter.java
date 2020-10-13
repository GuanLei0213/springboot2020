package com.gl.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

public class TransferTaskFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化TransferTaskFilter过滤器.........");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行TransferTaskFilter过滤器.........");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("销毁TransferTaskFilter过滤器.........");
    }
}
