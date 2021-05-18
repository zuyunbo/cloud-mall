package com.pattern.factory.v;

public class FactoryMain {

    public static void main(String[] args) {

        ICourse course = new JavaCourse();
        course.record();

    }

}
