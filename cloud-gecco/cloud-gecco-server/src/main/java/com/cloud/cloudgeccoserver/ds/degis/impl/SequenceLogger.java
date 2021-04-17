package com.cloud.cloudgeccoserver.ds.degis.impl;

import com.cloud.cloudgeccoserver.ds.degis.Logger;

public class SequenceLogger implements Logger {

    private final Logger[] loggers;

    SequenceLogger(Logger[] ls){
        this.loggers = ls;
    }

    @Override
    public void print(int level, String msg) {
        for( Logger l : loggers){
            l.print(level, msg);
        }
    }

    @Override
    public void logExcetion(Throwable e) {
        for( Logger l : loggers){
            l.logExcetion(e);
        }
    }
}
