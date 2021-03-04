package com.cloud.service.test;

import com.cloud.service.SuperService;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Author zuyunbo
 * @Date 2021/3/3  4:58 下午
 **/
public abstract class SuperSimpleController<S extends SuperService<Entity> , Entity > implements BaseController<Entity>  {

    Class<Entity> entityClass = null;

    @Autowired
    protected S baseService;

    @Override
    public Class<Entity> getEntityClass() {
        if (entityClass == null) {
            Type genericSuperclass = this.getClass().getGenericSuperclass();
            ParameterizedType p = (ParameterizedType)genericSuperclass;
            Type[] actualTypeArguments = p.getActualTypeArguments();
            this.entityClass =  (Class<Entity>)actualTypeArguments[1];
        }
        return this.entityClass;
    }

    @Override
    public SuperService<Entity> getBaseService() {
        return baseService;
    }


}
