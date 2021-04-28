package com.pattern.factory;

import com.pattern.simplefactory.ICourse;
import com.pattern.simplefactory.JavaCourse;

public class JavaCourseFactroy  implements ICourseFactory {

    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
