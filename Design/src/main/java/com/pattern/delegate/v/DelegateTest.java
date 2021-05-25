package com.pattern.delegate.v;

public class DelegateTest {

    public static void main(String[] args) {


        new Boss().command("登陆",new Leader());

    }

}
