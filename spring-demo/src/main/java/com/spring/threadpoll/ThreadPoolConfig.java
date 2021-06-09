package com.spring.threadpoll;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author zuyunbo
 * @Date 2021/6/7  1:52 下午
 **/

public class ThreadPoolConfig {

    private final static Logger LOGGER = LoggerFactory.getLogger(ThreadPoolConfig.class);


    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,200, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));

        long start = System.currentTimeMillis();

        for(int i=0;i<14;i++){

            synchronized (MyTask.class){
                int finalI = i;
                executor.execute(()->{
                    System.out.println("正在执行task "+ finalI);
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("task "+ finalI +"执行完毕");
                });
            }
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
        while (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
            LOGGER.info("线程还在执行。。。");
        }
        long end = System.currentTimeMillis();
        LOGGER.info("一共处理了【{}】", (end - start));

    }

    static class MyTask implements Runnable {
        private int taskNum;

        public MyTask(int num) {
            this.taskNum = num;
        }

        @Override
        public void run() {
            taskNum++;
        }
    }

}
