package com.pattern.factory.v1;

public class PythonCourseFactory implements CourseFactory{
    @Override
    public INote createNote() {
        return new PythonNote();
    }

    @Override
    public IVideo createVideo() {
        return new PythonVideo();
    }
}
