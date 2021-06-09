package com.spring.formework.beans.support;

import com.spring.formework.beans.config.GPBeanDefinition;
import com.spring.formework.context.support.GPAbstractApplicationContext;
import org.springframework.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GPDefaultListableBeanFactory extends GPAbstractApplicationContext {

    private final Map<String, GPBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();


}
