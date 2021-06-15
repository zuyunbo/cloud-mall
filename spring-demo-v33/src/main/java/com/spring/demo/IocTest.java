package com.spring.demo;

import com.spring.demo.core.supprot.BeanFactory;
import com.spring.demo.core.supprot.XmlBeanFactory;
import com.spring.demo.entity.Student;

public class IocTest {

    public static void main(String[] args) {

        // 创建IOC容器
        BeanFactory beanFactory = new XmlBeanFactory("bean-plane.xml");
        // 通过容器获取对象
        Student student = (Student)beanFactory.getBean("student");
        // 调用对象sayHello方法
        student.sayHello();

    }

}
