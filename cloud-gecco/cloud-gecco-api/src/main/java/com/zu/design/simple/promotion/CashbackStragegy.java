package com.zu.design.simple.promotion;

/**
 * @Author zuyunbo
 * @Date 2021/5/6  4:40 下午
 **/
public class CashbackStragegy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("返现促销，返回的金额转到支付宝账号");
    }
}
