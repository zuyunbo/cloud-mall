package com.pattern.strategy.v.factory;

import com.pattern.strategy.v.PromotionActivity;

public class PromotionStTest {

    public static void main(String[] args) {


        String promotionKey = "GROUPBUY";

        PromotionActivity promotionStrategy = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
        promotionStrategy.execute();
    }

}
