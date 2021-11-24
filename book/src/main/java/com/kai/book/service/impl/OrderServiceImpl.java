package com.kai.book.service.impl;

import com.kai.book.dao.BookDao;
import com.kai.book.dao.OrderDao;
import com.kai.book.dao.OrderItemDao;
import com.kai.book.dao.impl.BookDaoImpl;
import com.kai.book.dao.impl.OrderDaoImpl;
import com.kai.book.dao.impl.OrderItemDaoImpl;
import com.kai.book.pojo.*;
import com.kai.book.service.OrderService;

import java.util.Date;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/24
 **/
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        // 订单号===唯一性
        String orderId = System.currentTimeMillis() + "" + userId;

        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);
        for (CartItem item : cart.getItems().values()) {
            OrderItem orderItem = new OrderItem(null, item.getName(), item.getCount(), item.getPrice(), item.getTotalPrice(), orderId);
            orderItemDao.saveOrderItem(orderItem);
            // 更新库存和销量
            Book book = bookDao.queryBookById(item.getId());
            book.setSales(book.getSales() + item.getCount());
            book.setstock(book.getstock() - item.getCount());
            bookDao.updateBookById(book);
        }
        // 清空购物车
        cart.clear();
        return orderId;
    }
}
