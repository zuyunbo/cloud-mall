package com.cloud.service.syn;

/**
 * @Author zuyunbo
 * @Date 2021/6/1  5:47 下午
 **/
public class Miantintest {


    public static void main(String[] args) {
/*      SyncThread syncThread = new SyncThread();
      Thread thread = new Thread(syncThread,"Synchread1");
      Thread thread1 = new Thread(syncThread,"Synchread2");*/


        Thread thread1 = new Thread(new SyncThread(), "SyncThread1");
        Thread thread2 = new Thread(new SyncThread(), "SyncThread2");

        thread1.start();
        thread2.start();



    }

}
