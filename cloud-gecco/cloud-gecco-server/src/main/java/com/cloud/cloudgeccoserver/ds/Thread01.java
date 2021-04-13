package com.cloud.cloudgeccoserver.ds;

public class Thread01 {

    private static int count = 10;

    private static Object o = new Object();

    public static void main(String[] args) {

        synchronized (o){
            count--;
            System.out.println(Thread.currentThread().getName()+ "count"+count);
        }

    }
}
