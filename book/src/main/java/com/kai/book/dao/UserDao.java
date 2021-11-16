package com.kai.book.dao;

import com.kai.book.pojo.User;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/10
 **/
public interface UserDao {

    public User queryUserByUsername(String username);

    public User queryUserByUsernameAndPassword(String username, String password);

    public int saveUser(User user);



}
