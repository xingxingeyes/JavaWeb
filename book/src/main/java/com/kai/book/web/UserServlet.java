package com.kai.book.web;

import com.kai.book.pojo.User;
import com.kai.book.service.UserService;
import com.kai.book.service.impl.UserServiceImpl;
import com.kai.book.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/16
 **/
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();


    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("登录请求到loginServlet了");
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User loginUser = userService.login(new User(username, password, ""));
        if (loginUser == null) {
            // 把错误的信息和回显的表单信息保存到Request域中
            request.setAttribute("msg", "用户名或密码错误");
            request.setAttribute("username", username);

            // 登陆失败，跳转登录页面
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("user", loginUser);
            // 登陆成功
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }
    }

    /**
     * 注销
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.销毁session中用户登录的信息（或销毁session）
        request.getSession().invalidate();
        // 2.重定向到首页（或登录页面）
        response.sendRedirect(request.getContextPath());

    }


    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("注册请求到registServlet了");

        // 获取请求对象
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");

        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());



        // 获取Session中的验证码
        String token = (String)request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        // 删除Session中的验证码
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);



        // 2.检查验证码是否正确
        if (token != null && token.equalsIgnoreCase(code)) {
            // 3.检查用户名是否正确
            if (userService.existsUsername(username)) {
                // 用户名已存在
                System.out.println("用户名[" + username + "]已存在");
                // 验证码错误 把账号 邮箱回显到注册栏
                request.setAttribute("msg", "用户名已存在");
                request.setAttribute("username", username);
                request.setAttribute("email", email);

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
            request.setAttribute("msg", "验证码错误");
            request.setAttribute("username", username);
            request.setAttribute("email", email);


            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);

        }
    }

}
