package com.pattern.proxy.v1;

public class OrderDao {

    public int insert(Order order){
        System.out.println("orderDao 创建成功");
        return 1;

    }

}
