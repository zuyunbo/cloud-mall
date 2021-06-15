package com.spring.demo.core.supprot;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

public class XmlBeanDefinitionReader {

    final DefaultListableBeanFactory beanFactory;

    public XmlBeanDefinitionReader(DefaultListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }


    /**
     * 根据传递的配置文件
     * 解析配置
     * 注册bean
     * @param configPath
     */
    void loadBeanDefinitions(String configPath){
        // 1. 通过dom4j解析xml得到Document文档
        Document document = doLoadDocument(configPath);
        // 2. 遍历文档所有Bean标签
        Element rootElement = document.getRootElement();
        List<Element> list = rootElement.selectNodes("//bean");
        for (Element element : list) {
            // 3. 解析每一个Bean标签 封装一个BeanDefinition对象
            BeanDefinition beanDefinition = parseBeanDefinition(element);
            // 5. 将BeanDefinition和Property对象注册到容器
            beanFactory.registerBeanDefinition(beanDefinition);
        }
    }

    /**
     * 3. 解析每一个Bean标签 封装一个BeanDefinition对象
     * 4. 解析每一个Bean标签下的所有Property标签 封装一个Property对象
     */
    BeanDefinition parseBeanDefinition(Element element){
        BeanDefinition beanDefinition = new BeanDefinition();
        String beanName = element.attributeValue("id");
        String className = element.attributeValue("class");
        String scope = element.attributeValue("scope");
        beanDefinition.setBeanName(beanName);
        beanDefinition.setClassName(className);
        if(scope!=null&&!"".equals(scope)){
            beanDefinition.setScope(scope);
        }
        List<Element> propertyList = element.elements("property");
        for (Element propertyEle : propertyList) {
            Property property = new Property();
            property.setName(propertyEle.attributeValue("name"));
            property.setValue(propertyEle.attributeValue("value"));
            property.setRef(propertyEle.attributeValue("ref"));
            beanDefinition.getPropertyList().add(property);
        }
        return beanDefinition;
    }


    /**
     * 解析Document文档
     * @param configPath
     * @return
     */
    Document doLoadDocument(String configPath){
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(configPath);
        SAXReader saxReader = new SAXReader();
        try {
            return saxReader.read(resourceAsStream);
        } catch (DocumentException e) {
            e.printStackTrace();
            System.out.println("解析xml出现异常==>"+e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

}
