package com.kai.day15_filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/24
 **/
public class AdminFilter implements Filter {

    public AdminFilter() {
        System.out.println("1.Filter构造器方法AdminFilter()");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2.Filter的init()方法");

        // 1、获取 Filter 的名称 filter-name 的内容
        System.out.println("获取 Filter 的名称 filter-name 的内容:"+filterConfig.getFilterName());

        // 2、获取在 Filter 中配置的 init-param 初始化参数
        System.out.println("初始化参数username的值是:"+filterConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是:"+filterConfig.getInitParameter("url"));
        // 3、获取 ServletContext 对象
        System.out.println("获取 ServletContext 对象:"+filterConfig.getServletContext());

    }

    /**
     * 专门用于拦截请求，可用于权限检查
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("3.Filter的doFilter()方法");

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");

        // user==null，说明还没登录
        if (user == null) {
            httpServletRequest.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        } else {
            // 让程序继续往下访问用户目标资源
            chain.doFilter(request,response);
        }



    }

    @Override
    public void destroy() {
        System.out.println("4.Filter的destroy()方法");
    }
}
