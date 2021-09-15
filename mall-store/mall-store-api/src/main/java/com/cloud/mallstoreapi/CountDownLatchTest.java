package com.cloud.mallstoreapi;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Author zuyunbo
 * @Date 2021/9/15  1:27 上午
 **/
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始执行…… ……");
        ThreadFactory namedFactory = new ThreadFactoryBuilder().setNameFormat("Background--线程--%d").build();

        ThreadPoolExecutor es1 = new ThreadPoolExecutor(30, 30, 0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(200),namedFactory);

        for(;;){
            final CountDownLatch latch = new CountDownLatch(50);

            for (int i = 0; i < 20; i++) {
                es1.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                            System.out.println("Query Database Thread Start {}"+ Thread.currentThread().getName());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        latch.countDown();
                    }
                });
            }
            System.out.println("主线程执行");
            latch.await(50,TimeUnit.SECONDS);
            //第一个子线程执行
        }
    }
}
