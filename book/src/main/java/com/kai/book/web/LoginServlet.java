package com.kai.book.web;

import com.kai.book.pojo.User;
import com.kai.book.service.UserService;
import com.kai.book.service.impl.userServiceImpl;

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
    UserService userService = new userServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userService.login(new User(username, password, "")) == null) {
            // 登陆失败，跳转登录页面
            request.getRequestDispatcher("/pages/user/login.html").forward(request, response);
        } else {
            // 登陆成功
            request.getRequestDispatcher("/pages/user/login_success.html").forward(request, response);
        }
    }

}
