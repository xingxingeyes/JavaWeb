package com.kai.book.test;

import com.kai.book.web.UserServlet;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/16
 **/
public class UserServletTest {

    public void login() {
        System.out.println("这是login()方法");
    }

    public void regist() {
        System.out.println("这是regist()方法");
    }

    public void updateUser() {
        System.out.println("这是updateUser()方法");
    }

    public void updateUserPassword() {
        System.out.println("这是updateUserPassword()方法");
    }

    public static void main(String[] args) {
        String action = "updateUser";
        try {
            //  获取action业务鉴别字符串 获取响应的业务 方法反射对象
            Method method = UserServletTest.class.getDeclaredMethod(action);
            // System.out.println(method);
            // 调用目标业务方法
            method.invoke(new UserServletTest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
