package com.cloud.cloudgeccoserver.ds;

import java.util.concurrent.TimeUnit;

public class T01_helloVolatile {

    volatile boolean running = true;

    void m(){
        System.out.println("m start");
        while(running){

        }
        System.out.println("m end!");

    }

    public static void main(String[] args) {
        T01_helloVolatile t01_helloVolatile = new T01_helloVolatile();
        new Thread(t01_helloVolatile::m,"te").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t01_helloVolatile.running = false;
    }

}
