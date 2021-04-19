package com.cloud.rabbittask.dependeccy;

/**
 * @Author zuyunbo
 * @Date 2021/4/14  3:01 下午
 **/
public interface Component {

    /**
     * 用来返回这个component生成的对象类型
     * @return
     */
    Class getType();

    /**
     * 创建对象
     * @param dep
     * @return
     */
    Object create(Dependency dep);

    /**
     * 保证这个对象可以被创建
     * @param dep
     * @return
     */
    Class verify(Dependency dep);


}
