package com.kai.book.service.impl;

import com.kai.book.dao.UserDao;
import com.kai.book.dao.impl.UserDaoImpl;
import com.kai.book.pojo.User;
import com.kai.book.service.UserService;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/10
 **/
public class UserServiceImpl implements UserService {
    UserDao userdao = new UserDaoImpl();
    @Override
    public void registUser(User user) {
        userdao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userdao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userdao.queryUserByUsername(username) != null) {
            return true;
        }
        return false;
    }
}
