package com.kai.day13_captcha;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class RegistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 表单重复提交有三种常见的情况：
         *     一：提交完表单。服务器使用请求转来进行页面跳转。这个时候，用户按下功能键 F5，就会发起最后一次的请求。
         * 造成表单重复提交问题。解决方法：使用重定向来进行跳转
         *     二：用户正常提交服务器，但是由于网络延迟等原因，迟迟未收到服务器的响应，这个时候，用户以为提交失败，
         * 就会着急，然后多点了几次提交操作，也会造成表单重复提交。
         *     三：用户正常提交服务器。服务器也没有延迟，但是提交完成后，用户回退浏览器。重新提交。也会造成表单重复
         * 提交。
         */

        // 获取Session中的验证码
        String token = (String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        // 删除Session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        String code = req.getParameter("code");
        String username = req.getParameter("username");

        if (token != null && token.equalsIgnoreCase(code)) {
            System.out.println("保存到数据库："+username);
            resp.sendRedirect(req.getContextPath()+"/ok.jsp");
        }else {
            System.out.println("请不要重复提交表单");
        }


    }
}