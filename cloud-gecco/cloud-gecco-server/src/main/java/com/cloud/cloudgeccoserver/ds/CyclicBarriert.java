package com.cloud.cloudgeccoserver.ds;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarriert {


    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(20, () -> System.out.println("renman"));

        for (int i = 0; i < 100; i++) {
            new Thread(()-> {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }


    }

}
