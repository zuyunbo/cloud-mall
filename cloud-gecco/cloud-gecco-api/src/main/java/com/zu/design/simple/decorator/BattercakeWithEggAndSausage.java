package com.zu.design.simple.decorator;

/**
 * @Author zuyunbo
 * @Date 2021/5/8  5:08 下午
 **/
public class BattercakeWithEggAndSausage extends BattercakeWithEgg{

    @Override
    protected String getMsg() {
        return super.getMsg() + "1 根香肠";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 2;
    }
}
