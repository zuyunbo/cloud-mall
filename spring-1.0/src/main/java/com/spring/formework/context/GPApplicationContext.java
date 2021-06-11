package com.spring.formework.context;

import com.spring.formework.beans.GPBeanFactory;
import com.spring.formework.beans.config.GPBeanDefinition;
import com.spring.formework.beans.support.GPBeanDefinitionReader;
import com.spring.formework.beans.support.GPDefaultListableBeanFactory;
import com.spring.formework.context.support.GPAbstractApplicationContext;

import java.util.List;

public class GPApplicationContext extends GPDefaultListableBeanFactory implements GPBeanFactory {

    private String [] configLocations ;

    private GPBeanDefinitionReader beanDefinitionReader;

    public GPApplicationContext(String[] configLocations) {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected void refresh() {
       //1.定位配置文件
        beanDefinitionReader = new GPBeanDefinitionReader(configLocations);

        //2.加载配置文件，扫描相关的类，吧他们封装成BeanDefiition
        List<GPBeanDefinition> gpBeanDefinitions = beanDefinitionReader.loadBeanDefinitions();


        // 注册，把配置信息放到容器里（为IOC
        doRegisterBeanDefinition(gpBeanDefinitions);

        //

        doAutowrited();
    }

    private void doAutowrited() {



    }

    private void doRegisterBeanDefinition(List<GPBeanDefinition> gpBeanDefinitions) {


    }

    @Override
    public Object getBean(String beanName) {
        return null;
    }
}
