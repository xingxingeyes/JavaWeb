package com.kai.book.dao;

import com.kai.book.dao.impl.UserDaoImpl;
import com.kai.book.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/10
 **/
public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {

        System.out.println(userDao.queryUserByUsername("admin"));
        System.out.println(userDao.queryUserByUsernameAndPassword("admin", "admin"));

    }

    @Test
    public void queryUserByUsernameAndPassword() {
        System.out.println(userDao.queryUserByUsernameAndPassword("admin", "admin"));

    }

    @Test
    public void saveUser() {
        User user = new User("下午", "密码", "com");
        System.out.println(userDao.saveUser(user));
    }
}