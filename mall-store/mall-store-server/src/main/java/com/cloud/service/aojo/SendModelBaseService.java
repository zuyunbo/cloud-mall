package com.cloud.service.aojo;

import com.cloud.entity.PartAssembly;
import com.cloud.entity.PartMaster;
import com.cloud.entity.PartVersion;

/**
 * @Author zuyunbo
 * @Date 2021/3/9  9:53 上午
 **/
public interface SendModelBaseService<T,R> {

    Object getEntityClass();

    void sendDateByPojo(R entityClass,String key , String value);




}
