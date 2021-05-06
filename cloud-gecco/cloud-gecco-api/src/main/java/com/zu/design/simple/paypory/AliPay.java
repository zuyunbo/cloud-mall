package com.zu.design.simple.paypory;

/**
 * @Author zuyunbo
 * @Date 2021/5/6  5:38 下午
 **/
public class AliPay extends Payment{
    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    protected double queryBalance(String uid) {
        return 900;
    }
}
