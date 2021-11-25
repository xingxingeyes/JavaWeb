package com.kai.day15_filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/24
 **/
public class Filter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("filter2的线程："+Thread.currentThread().getName());
        System.out.println("filter2 request域"+ request.getParameter("username"));
        System.out.println("filter2中获取filter1中保存的数据是："+request.getAttribute("key1"));
        System.out.println("filter2 前置代码");
        chain.doFilter(request,response);
        System.out.println("filter2 后置代码");

    }

    @Override
    public void destroy() {

    }
}
