package com.cloud.cloudgeccoserver.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class T04_CountDownLatch {


    volatile List<Integer> count = new ArrayList<>();


    public int getCount() {
        return count.size();
    }

    public void setCount(int i) {
        count.add(i);
    }


    public static void main(String[] args) throws InterruptedException {
        T02_Volatile t02_volatile = new T02_Volatile();
        final Object o = new Object();
         CountDownLatch count = new CountDownLatch(1);
        CountDownLatch count1 = new CountDownLatch(1);

        new Thread(() -> {

                if (t02_volatile.getCount() != 5) {
                    try {
                        count.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("T2 结束");
            count1.countDown();



        }, "thread-1").start();

        TimeUnit.SECONDS.sleep(1);


        new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    t02_volatile.setCount(i);
                    System.out.println("add: " + i);
                    if (t02_volatile.getCount() == 5) {
                        count.countDown();
                        try {
                            count1.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                  /*  try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                }


        }, "thread-2").start();
    }


}
