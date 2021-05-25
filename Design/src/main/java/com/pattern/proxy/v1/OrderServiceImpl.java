package com.pattern.proxy.v1;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

public class OrderServiceImpl implements IOrderService {


    private OrderDao orderDao;

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = new OrderDao();
    }

    @Override
    public int createOrder(Order order) {
        return orderDao.insert(order);
    }
}
