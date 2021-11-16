package com.kai.day06_servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/8
 **/
public class HelloServlet1 implements Servlet {

    public HelloServlet1() {
        System.out.println("构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化");
        // 1.可以获取servlet程序的别名servlet-name的值
        System.out.println("Hello1Servlet 程序别名是:" + servletConfig.getServletName());
        // 2.获取初始化参数init-param
        System.out.println("初始化参数username的值是：" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是：" + servletConfig.getInitParameter("url"));
        // 3.获取severletContext对象
        System.out.println("ServletContext是：" + servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法时专门用来处理请求和访问的
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service方法");
        // 类型转换，因为他又getmethod()方法
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String methodStr = request.getMethod();
        if ("POST".equals(methodStr)) {
            doPost(methodStr);
        } else if ("GET".equals(methodStr)) {
            doGet(methodStr);
        }
    }

    public void doGet(String methodStr) {
        System.out.println(methodStr);
    }

    public void doPost(String methodStr) {
        System.out.println(methodStr);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("销毁方法");
    }
}
