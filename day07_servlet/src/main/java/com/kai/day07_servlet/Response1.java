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
public class Response1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("曾到此一游Response1");
        // 请求重定向的第一种方法
        // 设置响应状态码302， 表示重定向 (已搬迁)
//        response.setStatus(302);
        // 设置响应头，说明新的地址在那里
//        response.setHeader("Location","http://localhost:8080/day07_servlet/response2");
//        response.setHeader("Location","http://www.baidu.com");
        // 请求重定向的第二种方法
        response.sendRedirect("http://localhost:8080/day07_servlet/response2");
        response.sendRedirect("http://www.baidu.com");
    }
}
