package com.kai.day13_cookie_session.servlet;

import com.kai.day13_cookie_session.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/22
 **/
public class CookieServlet extends BaseServlet {


    protected void createCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.创建Cookie对象
        Cookie cookie = new Cookie("key2", "value2");
        // 2.通知客户端保存Cookie
        response.addCookie(cookie);

        Cookie cookie1 = new Cookie("key3", "value3");
        // 2.通知客户端保存Cookie
        response.addCookie(cookie1);
        response.getWriter().write("Cookie创建成功");
    }

    protected void getCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            // getName()返回Cookie的key
            // getValue()返回Cookie的Value值
            response.getWriter().write("cookie[" + cookie.getName() + "=" + cookie.getValue() + "]<br/>");
        }

        Cookie iwantCookie = CookieUtils.findCookie("key2", cookies);

        // for (Cookie cookie : cookies) {
        //     if ("key2".equals(cookie.getName())) {
        //         iwantCookie = cookie;
        //         break;
        //     }
        // }
        // 如果不能于null，说明赋值过
        if (iwantCookie != null) {
            response.getWriter().write("找到了需要的Cookie");
        }
    }

    protected void updateCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 方案一：
         *      1.先创建一个要修改的同名的cookie对象
         *      2.在构造器同时赋于新的cookie值
         *
         */

        // Cookie cookie = new Cookie("key1", "newValue1");
        // // 3.通知客户端保存修改
        // response.addCookie(cookie);
        //
        // response.getWriter().write("key1的value值已经修改了");

        /**
         * 方案二：
         *      1.先找到需要修改的Cookie对象
         *      2.调用setValue()方法赋于新的值
         *      3.调用response.addCookie()通知客户端保存修改
         *
         */
        Cookie cookie = CookieUtils.findCookie("key2", request.getCookies());
        if (cookie != null) {
            cookie.setValue("newValue2");
        }
        response.addCookie(cookie);

        response.getWriter().write("key2的value值已经修改了");
    }

    protected void defaultLife(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("defaultLife", "defaultLife");
        // 设置存活时间
        //      正数：表示在指定的秒数后过期
        //      负数：表示浏览器一关, Cookie就会被删除（默认是-1）
        //      零：表示马上删除Cookie
        cookie.setMaxAge(-1);
        response.addCookie(cookie);
    }

    protected void deleteNow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 先找到需要修改的Cookie对象
        Cookie cookie = CookieUtils.findCookie("key3", request.getCookies());
        // 2. 调用setMaxAge()
        if (cookie != null) {
            cookie.setMaxAge(0);
        }
        // 3. 调用response.addCookie() 通知客户端保存修改
        response.addCookie(cookie);

        response.getWriter().write("key3的cookie已经被删除");
    }

    protected void life3600(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("life3600", "life3600");
        cookie.setMaxAge(60*60); // 设置Cookie一小时后被删除
        response.addCookie(cookie);

        response.getWriter().write("已经创建了一个存货一小时的Cookie");
    }

    protected void testPath(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1", "path1");
        // request.getContextPath()得到工程路径
        cookie.setPath(request.getContextPath() + "/abc");
        response.addCookie(cookie);

        response.getWriter().write("创建了一个带有path路径的cookie");
    }

    }
