package com.cloud.cloudgeccoserver;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class psvm {


    public static void main(String[] args) {

        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        System.out.println("111");
    }

}
