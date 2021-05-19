package com.pattern.strategy.factory;

import com.pattern.strategy.CashbackStrategy;
import com.pattern.strategy.CouponStrategy;
import com.pattern.strategy.GroupBuyStrategy;
import com.pattern.strategy.PromotionStrategy;

import java.util.HashMap;
import java.util.Map;

public class PromotionStrategyFactory {

    private static Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();


    static {

        PROMOTION_STRATEGY_MAP.put(PromotionKey.COUPON, new CouponStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.CASHBACK, new CashbackStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.GROUPBUY, new GroupBuyStrategy());

    }

    public PromotionStrategyFactory() {
    }

    public static PromotionStrategy getPromotionStrategy(String promotionKey) {
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(promotionKey);
        return promotionStrategy == null ? promotionStrategy : promotionStrategy;
    }


    private interface PromotionKey {

        String COUPON = "COUPON";

        String CASHBACK = "CASHBACK";

        String GROUPBUY = "GROUPBUY";

    }

}
