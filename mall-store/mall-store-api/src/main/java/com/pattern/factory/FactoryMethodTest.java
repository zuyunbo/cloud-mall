package com.pattern.factory;

import com.pattern.simplefactory.ICourse;

public class FactoryMethodTest {

    public static void main(String[] args) {

        ICourseFactory factory = new PythonCourseFactroy();
        ICourse course = factory.create();
    }

}
