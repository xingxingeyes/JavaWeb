package com.kai.book.service;

import com.kai.book.pojo.Cart;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/24
 **/
public interface OrderService {

    public String createOrder(Cart cart, Integer userId);

}
