package com.zu.design.simple.promotion;

/**
 * @Author zuyunbo
 * @Date 2021/5/6  4:40 下午
 **/
public class GroupBuyStragegy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("拼团，满20人成团，全员享受团购价");
    }
}
