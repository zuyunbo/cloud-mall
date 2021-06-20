package com.spring.core;

/**
 * @Author zuyunbo
 * @Date 2021/6/12  4:22 下午
 **/
public interface BeanFactory {

    /**
     * 根据bean的名称从容器中获取bean对象
     *
     * @param name bean 名称
     * @return bean实例
     * @throws Exception 异常
     */
    Object getBean(String name) throws Exception;





}
