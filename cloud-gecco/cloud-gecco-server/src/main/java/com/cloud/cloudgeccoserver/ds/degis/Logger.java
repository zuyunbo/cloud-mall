package com.cloud.cloudgeccoserver.ds.degis;

public interface Logger {

    void print(int level,String msg);

    void logExcetion(Throwable e);

}
