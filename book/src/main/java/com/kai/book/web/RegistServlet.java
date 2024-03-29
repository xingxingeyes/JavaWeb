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
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("注册请求到registServlet了");
        UserService userService = new UserServiceImpl();

        // 获取请求对象
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");

        // 2.检查验证码是否正确
        if ("bnbnp".equalsIgnoreCase(code)) {
            // 3.检查用户名是否正确
            if (userService.existsUsername(username)) {
                // 用户名已存在
                System.out.println("用户名[" + username + "]已存在");
                // 验证码错误 把账号 邮箱回显到注册栏
                request.setAttribute("msg","用户名已存在");
                request.setAttribute("username",username);
                request.setAttribute("email",email);

                // 跳转回注册页面
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            } else {
                // 用户名不存在，进行注册
                userService.registUser(new User(username, password, email));
                // 注册成功
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }
        } else {
            System.out.println("验证码[" + code + "]不正确");
            // 验证码错误 把账号 邮箱回显到注册栏
            request.setAttribute("msg","验证码错误");
            request.setAttribute("username",username);
            request.setAttribute("email",email);


            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);

        }

    }

}
