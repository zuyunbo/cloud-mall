package com.pattern.strategy.v;

public class GroupBuyStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("无促销活动");
    }
}
