package com.cloud.cloudgeccoserver.ds;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    public char[] arg = "1234567".toCharArray();
    public char[] arg1 = "abcdefg".toCharArray();

    static     Thread t1 = null;
    static     Thread t2 = null;

    public static void main(String[] args) {
        LockSupportTest test = new LockSupportTest();

         t1 = new Thread(() ->{
          for(int i = 0; i<test.arg.length;i++){
              System.out.println(test.arg[i]);
              LockSupport.unpark(t2);
              LockSupport.park();
          }
        },"thread-1");

        t2 = new Thread(() ->{
            for(int i = 0; i<test.arg1.length;i++){
                System.out.println(test.arg1[i]);
                LockSupport.unpark(t1);
                LockSupport.park();
            }
        },"thread-2");

        t1.start();
        t2.start();
    }

}
