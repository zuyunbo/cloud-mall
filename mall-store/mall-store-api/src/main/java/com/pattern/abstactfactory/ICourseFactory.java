package com.pattern.abstactfactory;


import com.pattern.simplefactory.ICourse;

/**
 * 要求所有子工厂时间这个工厂
 */
public interface ICourseFactory {

   ICourse createCourse();

   INote createNote();

   IVideo createVideo();




}
