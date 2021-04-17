package com.cloud.rabbittask.juc;

/**
 * @Author zuyunbo
 * @Date 2021/4/13  5:35 下午
 **/
public class Thread001 {

    public volatile boolean va = true;

    public void mm(){

        System.out.println("start");
        while (va){

        }
        System.out.println("end");

    }

    public static void main(String[] args) {
        // 主线成 一直执行
        Thread001 thread001 = new Thread001();

        new Thread(thread001::mm, "t1").start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread001.va = false;
    }

}
