package com.cloud.rabbittask.dependeccy;

/**
 * @Author zuyunbo
 * @Date 2021/4/14  3:05 下午
 **/
public interface Container {

    Component getComponent(Object key);
    Component getComponentOfType(Class type);

}
