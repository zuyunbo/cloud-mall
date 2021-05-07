package com.zu.design.simple.paypory;

/**
 * @Author zuyunbo
 * @Date 2021/5/6  5:39 下午
 **/
public class WechatPay extends Payment{
    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 256;
    }
}
