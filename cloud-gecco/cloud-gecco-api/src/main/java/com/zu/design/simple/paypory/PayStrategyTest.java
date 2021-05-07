package com.zu.design.simple.paypory;

/**
 * @Author zuyunbo
 * @Date 2021/5/7  9:45 上午
 **/
public class PayStrategyTest {

    public static void main(String[] args) {

        Order order = new Order("1","202103446006789",324.45);

        System.out.println(order.pay(PayStrategy.UNION_PAY));


    }

}
