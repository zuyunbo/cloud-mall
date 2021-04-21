package com.cloud.cloudgeccoserver.ds;

import java.util.concurrent.*;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> c = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello Callable";
            }
        } ;
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(c);
        System.out.println(future.get());
        service.shutdown();
    }

}
