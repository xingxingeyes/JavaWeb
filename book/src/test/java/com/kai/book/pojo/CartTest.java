package com.kai.book.pojo;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/23
 **/
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java入门到精通",1,new BigDecimal(1),new BigDecimal(1)));
        cart.addItem(new CartItem(2,"java并发编程实战",1,new BigDecimal(1),new BigDecimal(1)));
        cart.addItem(new CartItem(3,"java数据结构与算法",1,new BigDecimal(1),new BigDecimal(1)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java入门到精通",1,new BigDecimal(1),new BigDecimal(1)));
        cart.addItem(new CartItem(2,"java并发编程实战",1,new BigDecimal(1),new BigDecimal(1)));
        cart.addItem(new CartItem(3,"java数据结构与算法",1,new BigDecimal(1),new BigDecimal(1)));

        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java入门到精通",1,new BigDecimal(1),new BigDecimal(1)));
        cart.addItem(new CartItem(2,"java并发编程实战",1,new BigDecimal(1),new BigDecimal(1)));
        cart.addItem(new CartItem(3,"java数据结构与算法",1,new BigDecimal(1),new BigDecimal(1)));

        cart.deleteItem(1);
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java入门到精通",1,new BigDecimal(1),new BigDecimal(1)));
        cart.addItem(new CartItem(2,"java并发编程实战",1,new BigDecimal(1),new BigDecimal(1)));
        cart.addItem(new CartItem(3,"java数据结构与算法",1,new BigDecimal(1),new BigDecimal(1)));

        cart.deleteItem(1);
        cart.clear();
        cart.addItem(new CartItem(1,"java入门到精通",1,new BigDecimal(10),new BigDecimal(1)));
        cart.updateCount(1,100);
        System.out.println(cart);


    }
}