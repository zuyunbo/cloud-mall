package com.cloud.cloudgeccoserver.ds;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureTaskTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> task = new FutureTask<Integer>(() ->{
            TimeUnit.MICROSECONDS.sleep(500);
            return 1000;
        });

        new Thread(task).start();
        System.out.println(task.get());

    }
}
