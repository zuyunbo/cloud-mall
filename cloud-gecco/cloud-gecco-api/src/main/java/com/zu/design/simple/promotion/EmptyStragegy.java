package com.zu.design.simple.promotion;

/**
 * @Author zuyunbo
 * @Date 2021/5/6  4:40 下午
 **/
public class EmptyStragegy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("无促销活动");
    }
}
