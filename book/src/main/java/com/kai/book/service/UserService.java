package com.kai.book.service;

import com.kai.book.pojo.User;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/10
 **/
public interface UserService {

    /**
     * 注册
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 验证用户名是否存在
     * @param username
     * @return
     */
    public boolean existsUsername(String username);
}
