package com.cloud.rabbittask.juc;

/**
 * @Author zuyunbo
 * @Date 2021/4/13  3:25 下午
 **/
class SyncThread implements Runnable {
    private static int count;

    public SyncThread() {
        count = 0;
    }

    public    void method() {
        synchronized (SyncThread.class){
            for (int i = 0; i < 5; i ++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void run() {
        method();
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        SyncThread syncThread = new SyncThread();
        Thread thread1 = new Thread(new SyncThread(), "SyncThread1");
        Thread thread2 = new Thread(new SyncThread(), "SyncThread2");
        thread1.start();
        thread2.start();
    }
}

