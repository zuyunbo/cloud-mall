package com.spring.formework.context;

import com.spring.formework.beans.GPBeanFactory;
import com.spring.formework.beans.support.GPDefaultListableBeanFactory;
import com.spring.formework.context.support.GPAbstractApplicationContext;

public class GPApplicationContext extends GPDefaultListableBeanFactory implements GPBeanFactory {


    @Override
    protected void refresh() {
        super.refresh();
    }

    @Override
    public Object getBean(String beanName) {
        return null;
    }
}
