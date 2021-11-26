package com.kai.book.dao.impl;

import com.kai.book.dao.OrderDao;
import com.kai.book.pojo.Order;

import java.util.List;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/24
 **/
public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public int saveOrder(Order order) {

        System.out.println("OrderDaoImpl程序在【"+Thread.currentThread().getName()+"】中");
        String sql = "insert into t_order values(?,?,?,?,?)";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }


    @Override
    public int updateOrderStatus(String orderId, int status) {
        String sql = "update t_order set `status`=? where `order_id`=?";
        return update(sql, status, orderId);

    }

    @Override
    public List<Order> queryMyOrders(int userId) {
        String sql = "select `order_id`,`create_time`,`price`,`status`,`user_id` from t_order where `user_id`=?";
        return queryForList(Order.class, sql, userId);
    }

    @Override
    public List<Order> queryAllOrders() {
        String sql = "select * from t_order";
        return queryForList(Order.class, sql);
    }
}
