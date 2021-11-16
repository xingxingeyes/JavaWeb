package com.kai.day07_servlet;

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
public class RequestAPIServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取请求的资源路径
        System.out.println("URI->"+request.getRequestURI());
        // 获取请求的统一资源定位符(绝对路径)
        System.out.println("URL->"+request.getRequestURL());
        // 获取客户端的ip地址
        System.out.println("客户端ip地址 RemoteHost->"+request.getRemoteHost());
        // 获取请求头
        System.out.println("请求头 User-Agent:->"+request.getHeader("User-Agent"));
        // 获取请求的方式GET或POST
        System.out.println("请求方式 Method：->"+request.getMethod());

    }
}
