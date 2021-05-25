package com.cloud.cloudgeccoserver.ds;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class DeathLockDemo {

    public static void main(String[] args) {
        deathLock();
    }

    /**
     * 一个模拟死锁的方法。
     */
    public static void deathLock() {
        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            try {
                lock1.lock();
                TimeUnit.SECONDS.sleep(1);
                lock2.lock();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                lock2.lock();
                TimeUnit.SECONDS.sleep(1);
                lock1.lock();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.setName("mythread1");
        t2.setName("mythread2");

        System.out.println("启动两个线程");
        t1.start();
        t2.start();
    }

}
