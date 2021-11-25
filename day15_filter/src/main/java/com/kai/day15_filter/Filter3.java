package com.kai.day15_filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/24
 **/
public class Filter3 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {

    }

}
