package com.cloud.rabbittask.dependeccy;

/**
 * @Author zuyunbo
 * @Date 2021/4/14  3:09 下午
 **/
public interface Function {

    Class getReturnType();

    Class[] getParameterTypes();

    Object call(Object[] args);

}
