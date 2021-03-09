package com.cloud.service.aojo.impl;

import com.cloud.entity.PartAssembly;
import com.cloud.entity.PartMaster;
import com.cloud.service.aojo.SendModelBaseService;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author zuyunbo
 * @Date 2021/3/9  9:53 上午
 **/
@Slf4j
public class SendModelByPartAssmelyImpl<T, R> extends CommonPropertyImpl<T> implements SendModelBaseService<T, R> {


    @Override
    public Object getEntityClass() {
        return new PartAssembly();
    }


    @Override
    public void sendDateByPojo(R entityClass, String key, String value) {
        set(entityClass, "set" + captureName(getPartAssemblyMap().get(key).toString()), value);
    }



}
