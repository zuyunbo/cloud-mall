package com.zu.design.simple;

/**
 * @Author zuyunbo
 * @Date 2021/5/6  4:20 下午
 **/
public class DelegateTest {

    public static void main(String[] args) {
        new Boss().command("登陆",new Leder());
    }

}
