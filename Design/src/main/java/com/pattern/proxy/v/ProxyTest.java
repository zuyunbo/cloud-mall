package com.pattern.proxy.v;

public class ProxyTest {

    public static void main(String[] args) {
        Father father = new Father(new Son());
        father.findLove();;

    }

}
