package com.pattern.simplefactory;

public class CourseFacyory implements ICourseFactory {

    @Override
    public ICourse create(Class clazz) {
        if (null != clazz) {
            try {
                return (ICourse) clazz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
