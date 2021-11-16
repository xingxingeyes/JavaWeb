package com.kai.day07_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/9
 **/
public class ParameterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置请求体的字符集为UTF-8，从而解决post请求的中文乱码问题
        // 在获取请求参数之前调用才有效
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] hobbies = request.getParameterValues("hobby");

        System.out.println("用户名"+username);
        System.out.println("密码"+password);
        System.out.println("兴趣爱好"+ Arrays.asList(hobbies));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] hobbies = request.getParameterValues("hobby");

        System.out.println("用户名"+username);
        System.out.println("密码"+password);
        System.out.println("兴趣爱好"+ Arrays.asList(hobbies));


    }
}
