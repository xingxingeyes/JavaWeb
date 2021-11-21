package com.kai.book.service;

import com.kai.book.pojo.Page;
import com.kai.book.pojo.User;
import com.kai.book.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/10
 **/
public class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User("眼镜", "密码", "234@163.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User("眼镜", "密码", "234@163.com")));
    }

    @Test
    public void existsUsername() {
        System.out.println(userService.existsUsername("眼镜"));
    }

}