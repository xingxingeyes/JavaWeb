package com.kai.book.dao.impl;

import com.kai.book.dao.UserDao;
import com.kai.book.pojo.User;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/10
 **/
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select * from t_user where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from t_user where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,password,email)values(?,?,?);";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

}
