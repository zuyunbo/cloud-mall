package com.pattern.adapter.v;

public class PowerAdapter implements DC5{


    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int outputDC5V() {


        System.out.println("解析ac220变为dc5");

        return 0;
    }
}
