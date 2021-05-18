package com.pattern.factory.v1;

public class PythonVideo implements IVideo{
    @Override
    public void record() {
        System.out.println("录制Pythob视频");
    }
}
