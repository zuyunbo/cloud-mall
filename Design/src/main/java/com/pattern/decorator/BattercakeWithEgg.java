package com.pattern.decorator;

public class BattercakeWithEgg extends Battercake{

    protected String getMsg() {
        return super.getMsg() + "+1 个鸡蛋 ";
    }
    @Override
    public int getPrice() {
        return super.getPrice() + 1;
    }
}
