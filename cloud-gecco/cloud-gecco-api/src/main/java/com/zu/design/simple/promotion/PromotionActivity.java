package com.zu.design.simple.promotion;

/**
 * @Author zuyunbo
 * @Date 2021/5/6  4:46 下午
 **/
public class PromotionActivity {
     private final PromotionStrategy promotionStrategy;


    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void execute(){
        promotionStrategy.doPromotion();
    }
}



