package com.cloud.cloudgeccoserver.ds.degis.impl;

import com.cloud.cloudgeccoserver.ds.degis.Logger;

public class NopLogger implements Logger {
    @Override
    public void print(int level, String msg) {

    }

    @Override
    public void logExcetion(Throwable e) {

    }
}
