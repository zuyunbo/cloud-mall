package com.zu.design.simple.promotion;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author zuyunbo
 * @Date 2021/5/6  4:47 下午
 **/
public class TGest {

/*    public static void main(String[] args) {

        PromotionActivity promotionActivity = new PromotionActivity(new CouponStrategy());
        PromotionActivity promotionActivity1 = new PromotionActivity(new CashbackStragegy());
        promotionActivity.execute();
        promotionActivity1.execute();

    }*/

/*    public static void main(String[] args) {
       PromotionActivity promotionActivity = null;

       String promotionKey = "COUPON";

       if(StringUtils.equals(promotionKey,"COUPON")){
           promotionActivity = new PromotionActivity(new CouponStrategy());
       }
        if(StringUtils.equals(promotionKey,"CASHBACK")) {
            promotionActivity = new PromotionActivity(new CashbackStragegy());
        }
        promotionActivity.execute();


    }*/


    public static void main(String[] args) {
        String promotionKey = "GROUPBUY";
        PromotionActivity promotionActivity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
        promotionActivity.execute();
    }


}
