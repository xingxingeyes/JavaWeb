package com.example.day08_jsp.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/11
 **/
public class MyServletContextListenerImpl implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("servletContext对象被创建");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("servletContext对象被销毁");
    }
}
