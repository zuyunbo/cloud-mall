package com.pattern.factory;

import com.pattern.simplefactory.ICourse;
import com.pattern.simplefactory.JavaCourse;
import com.pattern.simplefactory.PythonCourse;

public class PythonCourseFactroy implements ICourseFactory {

    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
