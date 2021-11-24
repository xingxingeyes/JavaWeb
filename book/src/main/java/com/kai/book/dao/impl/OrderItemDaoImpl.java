package com.kai.book.dao.impl;

import com.kai.book.dao.OrderDao;
import com.kai.book.dao.OrderItemDao;
import com.kai.book.pojo.Order;
import com.kai.book.pojo.OrderItem;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/24
 **/
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

    @Override
    public OrderItem queryOrderDetailByOrderId(Integer orderId) {
        String sql = "select * from where `order_id`=?";
        return queryForOne(OrderItem.class, sql, orderId);
    }

    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`)values(?,?,?,?,?)";
        return update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }
}
