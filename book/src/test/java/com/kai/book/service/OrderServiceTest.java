package com.kai.book.service;

import com.kai.book.pojo.Cart;
import com.kai.book.pojo.CartItem;
import com.kai.book.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLOutput;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/24
 **/
public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java入门到精通",1,new BigDecimal(1),new BigDecimal(1)));
        cart.addItem(new CartItem(2,"java并发编程实战",1,new BigDecimal(1),new BigDecimal(1)));
        cart.addItem(new CartItem(3,"java数据结构与算法",1,new BigDecimal(1),new BigDecimal(1)));
        System.out.println(cart);
        OrderService orderService = new OrderServiceImpl();
        System.out.println("订单号是："+orderService.createOrder(cart, 20));

    }
}