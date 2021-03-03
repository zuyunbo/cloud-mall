package com.cloud.service.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Author zuyunbo
 * @Date 2021/3/3  4:58 下午
 **/
public abstract class SuperSimpleController<Entity> implements BaseController<Entity>  {

    Class<Entity> entityClass = null;


    @Override
    public Class<Entity> getEntityClass() {
        if (entityClass == null) {
            Type genericSuperclass = this.getClass().getGenericSuperclass();
            ParameterizedType p = (ParameterizedType)genericSuperclass;
            System.out.println("dsds" + p);
            Type[] actualTypeArguments = p.getActualTypeArguments();
            System.out.println("dsds1111" + p.getActualTypeArguments()[1].toString());
            this.entityClass =  (Class<Entity>)actualTypeArguments[1];
        }
        return this.entityClass;
    }


}
