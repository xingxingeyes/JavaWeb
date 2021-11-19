package com.kai.book.web;

import com.kai.book.pojo.User;
import com.kai.book.service.UserService;
import com.kai.book.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/10
 **/
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("登录请求到loginServlet了");
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userService.login(new User(username, password, "")) == null) {
            // 把错误的信息和回显的表单信息保存到Request域中
            request.setAttribute("msg","用户名或密码错误");
            request.setAttribute("username",username);

            // 登陆失败，跳转登录页面
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
            // 登陆成功
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }
    }

}
