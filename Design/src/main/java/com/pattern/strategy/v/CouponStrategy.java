package com.pattern.strategy.v;

public class CouponStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("领取优惠隽，课程的价格直接减优惠卷面值价格");
    }
}
