package com.spring.jdk;

/**
 * @Author zuyunbo
 * @Date 2021/6/15  1:47 下午
 **/
public class HelloWorld implements Hello{
    @Override
    public void morning(String name) {
        System.out.println("Good morning + " + name);
    }
}
