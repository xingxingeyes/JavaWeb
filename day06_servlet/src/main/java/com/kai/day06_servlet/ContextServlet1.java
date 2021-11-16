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
public class ContextServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        System.out.println("ContextServlet1 的context地址是："+context);
        System.out.println("保存前 Context1 获取 key1的值是：" + context.getAttribute("key1"));

        context.setAttribute("key1", "value1");
        System.out.println("Context1 中获取域数据key1的值是：" + context.getAttribute("key1"));
    }
}
