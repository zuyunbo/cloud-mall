package com.cloud.controller;

import com.cloud.param.CApplicationParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zuyunbo
 * @Date 2021/6/30  9:04 下午
 **/
public class test {

    public static int s = 0;


    public  void d() throws InterruptedException {
        s ++;
        System.out.println(s);
        Thread.sleep(100);
        d();
    }



    public static void main(String[] args) throws InterruptedException {
       test test = new test();
       test.d();


    }

}
