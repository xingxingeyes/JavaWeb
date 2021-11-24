package com.kai.book.dao;

import com.kai.book.dao.impl.OrderDaoImpl;
import com.kai.book.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/24
 **/
public class OrderDaoTest {
    OrderDao orderDao = new OrderDaoImpl();
    @Test
    public void saveOrder() {

        orderDao.saveOrder(new Order( "21334", new Date(), new BigDecimal(10), 0, 20));
    }

    @Test
    public void updateOrderStatus() {
        orderDao.updateOrderStatus("21334",1);
    }

    @Test
    public void queryMyOrders() {
        System.out.println(orderDao.queryMyOrders(20));
    }

    @Test
    public void queryAllOrders() {
        System.out.println(orderDao.queryAllOrders());
    }
}