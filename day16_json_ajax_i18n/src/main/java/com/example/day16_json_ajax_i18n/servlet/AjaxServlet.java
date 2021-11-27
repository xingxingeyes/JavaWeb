package com.example.day16_json_ajax_i18n.servlet;

import com.example.day16_json_ajax_i18n.pojo.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/26
 **/
public class AjaxServlet extends BaseServlet{

    protected void JavaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("JavaScriptAjax请求过来了");
        Person person = new Person(1, "林深时见鹿");
        Gson gson = new Gson();
        String personJsonStr = gson.toJson(person);
        resp.getWriter().write(personJsonStr);
    }
    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryAjax请求过来了");
        Person person = new Person(1, "林深时见鹿");
        Gson gson = new Gson();
        String personJsonStr = gson.toJson(person);
        resp.getWriter().write(personJsonStr);
    }
    protected void jQueryGetAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryGetAjax请求过来了");
        Person person = new Person(1, "林深时见鹿");
        Gson gson = new Gson();
        String personJsonStr = gson.toJson(person);
        resp.getWriter().write(personJsonStr);
    }
    protected void jQueryPostAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryPostAjax请求过来了");
        Person person = new Person(1, "林深时见鹿");
        Gson gson = new Gson();
        String personJsonStr = gson.toJson(person);
        resp.getWriter().write(personJsonStr);
    }
    protected void jQueryGetJsonAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryGetJsonAjax请求过来了");
        Person person = new Person(1, "林深时见鹿");
        Gson gson = new Gson();
        String personJsonStr = gson.toJson(person);
        resp.getWriter().write(personJsonStr);
    }
    protected void jQuerySerializeAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQuerySerializeAjax请求过来了");
        System.out.println("用户名："+req.getParameter("username"));
        System.out.println("密码："+req.getParameter("password"));


        Person person = new Person(1, "林深时见鹿");
        Gson gson = new Gson();
        String personJsonStr = gson.toJson(person);
        resp.getWriter().write(personJsonStr);
    }
}
