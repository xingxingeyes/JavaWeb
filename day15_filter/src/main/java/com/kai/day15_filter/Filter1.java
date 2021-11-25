package com.kai.day15_filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/24
 **/
public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filter1的线程："+Thread.currentThread().getName());
        System.out.println("filter1 request域"+ request.getParameter("username"));
        request.setAttribute("key1","value1");
        System.out.println("filter1 前置代码");
        chain.doFilter(request,response);
        System.out.println("filter1 后置代码");

    }

    @Override
    public void destroy() {

    }
}
