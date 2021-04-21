package com.cloud.cloudgeccoserver.ds.degis.impl;

import com.cloud.cloudgeccoserver.ds.degis.Logger;

public class SimpleLogger implements Logger {
    @Override
    public void print(int level, String msg) {
        System.out.println(msg);
    }



    @Override
    public void logExcetion(Throwable e) {
         e.printStackTrace();
    }
}
