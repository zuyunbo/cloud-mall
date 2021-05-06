package com.pattern.abstactfactory;

import com.pattern.simplefactory.ICourse;
import com.pattern.simplefactory.JavaCourse;

public class JavaCouseFactory implements ICourseFactory{
    @Override
    public ICourse createCourse() {
        return new JavaCourse();
    }

    @Override
    public INote createNote() {
        return null;
    }

    @Override
    public IVideo createVideo() {
        return null;
    }
}
