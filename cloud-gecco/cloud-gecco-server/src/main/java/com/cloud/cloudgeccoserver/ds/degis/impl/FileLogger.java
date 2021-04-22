package com.cloud.cloudgeccoserver.ds.degis.impl;

import com.cloud.cloudgeccoserver.ds.degis.Logger;

public class FileLogger implements Logger {
    @Override
    public void print(int level, String msg) {
        System.out.println("write msg to log");
    }

    @Override
    public void logExcetion(Throwable e) {
        System.out.println("write exception to log file");
    }
}
