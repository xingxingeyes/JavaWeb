package com.kai.day06_servlet;

import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

public class HelloServlet2 extends HttpServlet {
    private String message;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");

        // ServletConfig是在HttpServlet父类ServletConfig的init(ServletConfig servletConfig)中赋值的，
        // 重写了父类的init(ServletConfig servletConfig)后，要使用serverletConfig必须调用super.init(servletConfig);
        ServletConfig servletConfig = getServletConfig();
        // 1.可以获取servlet程序的别名servlet-name的值
        System.out.println("HelloServlet2 程序别名是:" + servletConfig.getServletName());
        // 2.获取初始化参数init-param
        System.out.println("初始化参数username2的值是：" + servletConfig.getInitParameter("username2"));
        System.out.println("初始化参数url2的值是：" + servletConfig.getInitParameter("url2"));
        // 3.获取severletContext对象
        System.out.println("ServletContext是：" + servletConfig.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        System.out.println("HelloServlet 的doPost方法");
        ServletConfig servletConfig = getServletConfig();
    }

    public void destroy() {
    }
}