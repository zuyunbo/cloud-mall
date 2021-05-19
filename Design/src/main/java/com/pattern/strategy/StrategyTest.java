package com.pattern.strategy;

public class StrategyTest {


    public static void main(String[] args) {

        PromotionActivity promotionActivityA = new PromotionActivity(new CashbackStrategy());
        PromotionActivity promotionActivityB = new PromotionActivity(new CashbackStrategy());
        promotionActivityA.execute();
        promotionActivityB.execute();


    }

}
