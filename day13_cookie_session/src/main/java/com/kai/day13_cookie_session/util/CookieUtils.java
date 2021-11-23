package com.kai.day13_cookie_session.util;

import javax.servlet.http.Cookie;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/22
 **/
public class CookieUtils {
    public static Cookie findCookie(String name, Cookie[] cookies) {
        if (name == null || cookies == null || cookies.length == 0) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }
}
