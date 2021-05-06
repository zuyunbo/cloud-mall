package com.zu.design.simple.paypory;

/**
 * @Author zuyunbo
 * @Date 2021/5/6  5:38 下午
 **/
public class UnionPay extends Payment{
    @Override
    public String getName() {
        return "银联支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 120;
    }
}
