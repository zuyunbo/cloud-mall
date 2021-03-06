package com.cloud.cloudgeccoserver.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class T02_Volatile {

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

        new Thread(() -> {
            synchronized (o) {

                if (t02_volatile.getCount() != 5) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("T2 结束");

            }

        }, "thread-1").start();

        TimeUnit.SECONDS.sleep(1);


        new Thread(() -> {
            synchronized (o) {
                for (int i = 0; i < 10; i++) {
                    t02_volatile.setCount(i);
                    System.out.println("add: " + i);
                    if (t02_volatile.getCount() == 5) {
                        o.notify();
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }, "thread-2").start();
    }

}
