package com.kai.book.dao;

import com.kai.book.pojo.Order;

import java.util.List;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/24
 **/
public interface OrderDao {

    public int saveOrder(Order order);

    public int updateOrderStatus(String orderId, int status);

    public List<Order> queryMyOrders(int userId);

    public List<Order> queryAllOrders();


}
