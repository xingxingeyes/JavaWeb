package com.kai.day06_servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/9
 **/
public class ContextServlet extends HttpServlet {
    // 1、获取 web.xml 中配置的上下文参数 context-param
    // 2、获取当前的工程路径，格式: /工程路径
    // 3、获取工程部署后在服务器硬盘上的绝对路径
    // 4、像 Map 一样存取数据
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        getServletContext();
        // 1、获取 web.xml 中配置的上下文参数 context-param
        ServletContext context = getServletContext();
        System.out.println("");
        String username = context.getInitParameter("username");
        System.out.println("servletContext-------->username:" + username);
        System.out.println("ServletContext-------->password:" + context.getInitParameter("password"));
        System.out.println("----------------------------------------");

        // 2、获取当前的工程路径，格式: /工程路径
        System.out.println("当前工程路径："+context.getContextPath());
        // 3、获取工程部署后在服务器硬盘上的绝对路径
        /**
         * 斜杠被服务器解析地址为http://ip:port/工程名/ 映射到IDEA代码的webapp目录<br/>
         */
        System.out.println("工程部署路径："+context.getRealPath("/"));
        System.out.println("工程下css目录的绝度路径是："+context.getRealPath("/css"));
        System.out.println("工程下imgs目录1.jpg的绝度路径是："+context.getRealPath("/imgs/1.jpg"));
    }
}
