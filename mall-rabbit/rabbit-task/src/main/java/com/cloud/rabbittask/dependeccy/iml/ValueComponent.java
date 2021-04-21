package com.cloud.rabbittask.dependeccy.iml;

import com.cloud.rabbittask.dependeccy.Component;
import com.cloud.rabbittask.dependeccy.Dependency;

/**
 * @Author zuyunbo
 * @Date 2021/4/14  3:07 下午
 **/
public class ValueComponent implements Component {

    private final Object v;

    @Override
    public Class getType() {
        return v==null?null:v.getClass();
    }

    @Override
    public Object create(Dependency dep) {
        return v;
    }

    @Override
    public Class verify(Dependency dep) {
        return getType();
    }

    public ValueComponent(Object v) {
        this.v = v;
    }
}
