package com.cloud.service.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author zuyunbo
 * @Date 2021/3/5  1:23 下午
 **/
public class TestMainCon<T> {


    private volatile boolean direction = true;

    private List<T> queue1 = new LinkedList<>();

    private List<T> queue2 = new LinkedList<>();

    private Object readLock = new Object();

    private Object writeLock = new Object();

    public void add(T o){

        synchronized (readLock) {
            if (direction) {
                queue1.add(o);
            } else {
                queue2.add(o);
            }
        }

    }

    public T poll() {
        synchronized (writeLock) {
            if (direction) {
                return unqueue(queue2, queue1);
            }
            return unqueue(queue1, queue2);
        }
    }

    private T unqueue(List<T> poll, List<T> put) {
        if (poll.isEmpty()) {
            synchronized (readLock) {
                if (put.isEmpty())
                    return null;
                direction = !direction;
            }
            return put.remove(0);
        } else {
            return poll.remove(0);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd ");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));

    }

    public static void test1(int count) throws InterruptedException {
        TestMainCon<Integer> queue1 = new TestMainCon<>();

        long l = System.currentTimeMillis();

        Thread thread = new Thread(() -> {
            int i = 0;
            while (i < count) {
                queue1.add(i++);
            }
        });
        thread.start();
        Thread thread1 = new Thread(() -> {
            while (true){
                Integer poll = queue1.poll();
                if(poll!=null &&  poll== count -1)
                    return ;
            }
        });
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println(System.currentTimeMillis() - l);
    }

    public static void test2(int count) throws InterruptedException {
        LinkedBlockingQueue<Integer> queue1 = new LinkedBlockingQueue();

        long l = System.currentTimeMillis();

        Thread thread = new Thread(() -> {
            int i = 0;
            while (i < count) {
                queue1.add(i++);
            }
        });
        thread.start();
        Thread thread1 = new Thread(() -> {
            while (true){
                Integer poll = queue1.poll();
                if(poll!=null &&  poll== count -1)
                    return ;
            }
        });
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println(System.currentTimeMillis() - l);
    }


}
