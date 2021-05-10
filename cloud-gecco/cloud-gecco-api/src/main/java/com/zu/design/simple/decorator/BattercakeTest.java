package com.zu.design.simple.decorator;

/**
 * @Author zuyunbo
 * @Date 2021/5/8  5:09 下午
 **/
public class BattercakeTest {

    public static void main(String[] args) {

        Battercake battercake = new Battercake();
        System.out.println(battercake.getMsg() + ",总价格："+ battercake.getPrice());

        Battercake battercake1 = new BattercakeWithEgg();
        System.out.println(battercake1.getMsg() + ",总价格："+ battercake1.getPrice());

        Battercake battercake2 = new BattercakeWithEggAndSausage();
        System.out.println(battercake2.getMsg() + ",总价格："+ battercake2.getPrice());

    }

}
