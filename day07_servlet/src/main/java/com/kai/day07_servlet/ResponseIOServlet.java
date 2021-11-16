package com.kai.day07_servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/9
 **/
public class ResponseIOServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置服务器字符集为UTF-8
//        response.setCharacterEncoding("UTF-8");
        // 通过响应头，设置浏览器也是用UTF-8字符集
//        response.setHeader("content-type","text/html; charset=UTF-8");
        // 它会同时设置服务器和客户端都是用UTF-8字符集，还设置了响应头
        // 此方法一定要在获取流对象之前调用才有效
        response.setContentType("text/html; charset=UTF-8");

        System.out.println(response.getCharacterEncoding());
        // 字符流
        PrintWriter writer = response.getWriter();

        // 字节流
//        response.getOutputStream();
        writer.write("response`s content!!!");
        writer.write("中文响应");

    }
}
