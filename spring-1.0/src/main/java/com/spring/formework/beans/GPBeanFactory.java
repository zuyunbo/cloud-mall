package com.spring.formework.beans;

/**
 *
 */
public interface GPBeanFactory {

    /**
     * 根据beanName从IOC容器中获得一个实例
     * @param beanName
     * @return
     */
    Object getBean(String beanName);




}
