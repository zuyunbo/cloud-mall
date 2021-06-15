package com.spring.demo.core.supprot;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultListableBeanFactory implements BeanFactory{


    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    private Map<String,Object> singletonObjects = new ConcurrentHashMap<>();



    @Override
    public Object getBean(String beanName) {
        return null;
    }

    public void registerBeanDefinition(BeanDefinition beanDefinition){
        beanDefinitionMap.put(beanDefinition.getBeanName(),beanDefinition);
    }
}
