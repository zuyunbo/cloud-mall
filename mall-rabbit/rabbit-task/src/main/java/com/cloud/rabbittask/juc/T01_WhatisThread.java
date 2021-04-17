package com.cloud.rabbittask.juc;

import java.util.concurrent.TimeUnit;

/**
 * @Author zuyunbo
 * @Date 2021/4/13  2:06 下午
 **/
public class T01_WhatisThread {

    public static class T extends Thread {

        @Override
        public void run() {
            try {
                TimeUnit.MICROSECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run方法执行了");
        }

    }


    public static void main(String[] args) {
        // new T().start();
        new T().run();
        for(int i=0;i<10;i++){
            System.out.println("main方法执行了");
        }
    }

}
