package com.cloud.cloudgeccoserver.ds.degis.impl;

import com.cloud.cloudgeccoserver.ds.degis.Logger;

public class WriterLogger implements Logger {
    public void print(int level, String msg){
        System.out.println("打印消息");
    }
    public void logExcetion(Throwable e){
        e.printStackTrace();
    }

}
