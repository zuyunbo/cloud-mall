package com.cloud.service.service.impl;

import com.cloud.service.config.AutoGenConfig;
import com.cloud.service.entity.TableEntity;
import com.cloud.service.service.GenerateCode;
import com.cloud.service.service.GenerateCodePathConfig;

import java.util.Map;

public class ServiceCode extends GenerateCode {


    public TableEntity autoGenEntity;


    public ServiceCode(TableEntity autoGenEntity) {
        this.autoGenEntity = autoGenEntity;
    }

    /**
     * 生成代码
     */
    @Override
    public void generateAnInstance() {
        Map<String, Object> codeMap = GenerateCodePathConfig.getCodeMap(autoGenEntity, AutoGenConfig.entityPackageOutPath, AutoGenConfig.entityBasePath);
        GenerateCodePathConfig.writeCode(codeMap,AutoGenConfig.serviceWritePath,GenerateCodePathConfig.getDaoPath(),AutoGenConfig.serviceBasePath,autoGenEntity.getClassName()+"Service");
    }

}
