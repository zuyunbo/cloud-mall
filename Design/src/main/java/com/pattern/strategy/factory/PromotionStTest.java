package com.pattern.strategy.factory;

import com.pattern.strategy.PromotionActivity;
import com.pattern.strategy.PromotionStrategy;

public class PromotionStTest {

    public static void main(String[] args) {


        String promotionKey = "GROUPBUY";

        PromotionActivity promotionStrategy = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
        promotionStrategy.execute();
    }

}
