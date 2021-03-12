package com.cloud.service.aojo.impl;

import com.cloud.entity.Common;
import com.cloud.entity.PartCommon;
import com.cloud.entity.PartMaster;
import com.cloud.entity.PartVersion;
import com.cloud.service.aojo.SendModelBaseService;
import lombok.extern.slf4j.Slf4j;

/**
 * 用于生成part版本数据
 *
 * @Author zuyunbo
 * @Date 2021/3/9  9:53 上午
 **/
@Slf4j
public class SendModelByPartVersionImpl<T, R> extends CommonPropertyImpl<T> implements SendModelBaseService<T, R> {


    @Override
    public Object getEntityClass() {
        return new PartCommon();
    }


    @Override
    public void sendDateByPojo(R entityClass, String key, String value) {
        set(entityClass, "set" + captureName(getCommonMap().get(key).toString()), value);
    }



}
