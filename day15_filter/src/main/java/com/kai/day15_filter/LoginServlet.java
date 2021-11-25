package com.kai.day15_filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/24
 **/
public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if("admin".equals(username)){
            req.getSession().setAttribute("user", username);
            resp.getWriter().write("登录成功！");
        }else {
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

}
