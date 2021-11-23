package com.kai.day13_cookie_session.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/22
 **/
public class SessionServlet extends BaseServlet {

    protected void createOrGetSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建和获取session会话对象
        HttpSession session = request.getSession();
        // 判断当前session会话，是否是新创建出来的
        boolean isNew = session.isNew();
        // 获取session会话的唯一标识id
        String id = session.getId();

        response.getWriter().write("得到的session，它的id是" + id + "<br>");
        response.getWriter().write("这个session是否是新创建的" + isNew + "<br>");
    }

    /**
     * 往session域中保存数据
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void setAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("key1", "value1");
        response.getWriter().write("已经往session中保存了数据");
    }

    /**
     * 获取session域中的数据
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object attribute = request.getSession().getAttribute("key1");
        response.getWriter().write("从session中获取key1的数据是" + attribute);
    }

    protected void defaultLife(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取session的默认超时时长 1800秒 30分钟
        // session的超时时长指的是，客户端两次请求的最大间隔时长
        int maxInactiveInterval = request.getSession().getMaxInactiveInterval();

        response.getWriter().write("session的默认超时时长是：" + maxInactiveInterval + "秒");
    }

    protected void life3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // 设置当前session 3秒后超时
        // 值为正数设定session的超时时长
        // 值为负数表示永不超时(极少使用)
        // invalidate()会话马上消失
        session.setMaxInactiveInterval(3);

        response.getWriter().write("当前session已经设置为3秒后超时");
    }

    protected void deleteNow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // invalidate()会话马上消失
        session.invalidate();

        response.getWriter().write("当前session已经设置了超时（无效）");
    }

}
