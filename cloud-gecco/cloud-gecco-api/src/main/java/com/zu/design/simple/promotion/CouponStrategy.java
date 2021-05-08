package com.zu.design.simple.promotion;

/**
 * @Author zuyunbo
 * @Date 2021/5/6  4:40 下午
 **/
public class CouponStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("领取优惠卷，课程的价格直接减优惠抵扣");
    }
}
