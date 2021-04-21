package com.cloud.rabbittask.dependeccy;

/**
 * @Author zuyunbo
 * @Date 2021/4/14  2:54 下午
 **/
public interface Dependency {

    // 负责解析一个函数
    Object getArgument(int i,Class type);

    /**
     * 类型为String的解析依赖。于是就调用
     * getArgument(2, String.class)。
     * @param i
     * @param type
     * @return
     */
    Class verifyArgument(int i, Class type);

    /**
     * 负责解析一个用某个key来标识的属性。比如一个javabean的property。
     * @param key
     * @param type
     * @return
     */
    Object getProperty(Object key, Class type);

    Class verifyProperty(Object key, Class type);

}
