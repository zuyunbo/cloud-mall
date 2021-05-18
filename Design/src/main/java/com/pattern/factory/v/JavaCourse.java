package com.pattern.factory.v;

public class JavaCourse implements ICourse{
    @Override
    public void record() {
        System.out.println("录制JAVA视频");
    }
}
