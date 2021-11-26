package com.kai.day15_filter.threadLocal;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/25
 **/
public class OrderService {
    public void createOrder() {
        String name = Thread.currentThread().getName();
        System.out.println("OrderService 当前线程【"+name+"】中保存的数据是："+ThreadLocalTest.threadLocal.get());
    }
}
