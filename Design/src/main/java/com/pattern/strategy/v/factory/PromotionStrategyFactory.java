package com.pattern.strategy.v.factory;

import com.pattern.strategy.v.CashbackStrategy;
import com.pattern.strategy.v.CouponStrategy;
import com.pattern.strategy.v.GroupBuyStrategy;
import com.pattern.strategy.v.PromotionStrategy;

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
