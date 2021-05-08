package com.zu.design.simple.promotion;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author zuyunbo
 * @Date 2021/5/6  5:06 下午
 **/
public class PromotionStrategyFactory {

    private final static Map<String ,PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();

    static {
        PROMOTION_STRATEGY_MAP.put(PromotionKey.CASHBACK,new CashbackStragegy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.COUPON,new CouponStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.GROUPBUY,new GroupBuyStragegy());
    }

    private static final PromotionStrategy NON_PROMOTION = new EmptyStragegy();

    public static PromotionStrategy getPromotionStrategy(String promotionKey){
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(promotionKey);
        return promotionStrategy == null ? NON_PROMOTION : promotionStrategy;
    }


    private interface PromotionKey{
        String COUPON = "COUPON";
        String CASHBACK ="CASHBACK";
        String GROUPBUY = "GROUPBUY";
    }


}
