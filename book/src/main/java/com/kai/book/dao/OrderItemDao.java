package com.kai.book.dao;

import com.kai.book.pojo.OrderItem;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/24
 **/
public interface OrderItemDao {

    public int saveOrderItem(OrderItem orderItem);

    public OrderItem queryOrderDetailByOrderId(Integer orderId);
}
