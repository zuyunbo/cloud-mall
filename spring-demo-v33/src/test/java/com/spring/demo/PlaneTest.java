package com.spring.demo;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {
    @org.junit.jupiter.api.Test
    void getBrand() throws IOException {

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        Resource resource = resolver.getResource("classpath:com.spring.resources/bean-plane.xml");

        System.out.println(resource.getURL());

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        reader.loadBeanDefinitions(resource);

        System.out.println("inti BeanFactory successfully");

/*        Plane plane = beanFactory.getBean("plane",Plane.class);

        System.out.println("Plane Bean  is ready to use");

        plane.introduce();*/


    }
}