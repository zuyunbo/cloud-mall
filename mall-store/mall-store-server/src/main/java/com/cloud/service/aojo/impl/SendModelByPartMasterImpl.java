package com.cloud.service.aojo.impl;

import com.cloud.entity.PartAssembly;
import com.cloud.entity.PartMaster;
import com.cloud.entity.PartVersion;
import com.cloud.service.aojo.SendModelBaseService;
import com.cloud.service.xsd.part.ac.*;
import lombok.extern.slf4j.Slf4j;

import java.lang.Class;
import java.util.List;

/**
 * @Author zuyunbo
 * @Date 2021/3/9  9:53 上午
 **/
@Slf4j
public class SendModelByPartMasterImpl<T, R> extends CommonPropertyImpl<T> implements SendModelBaseService<T, R> {


    @Override
    public Object getEntityClass() {
        return new PartMaster();
    }


    @Override
    public void sendDateByPojo(R entityClass, String key, String value) {
        set(entityClass, "set" + captureName(getPartMasterMap().get(key).toString()), value);
    }



}
