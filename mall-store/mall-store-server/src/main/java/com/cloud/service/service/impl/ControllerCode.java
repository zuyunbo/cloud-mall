package com.cloud.service.service.impl;

import com.cloud.service.config.AutoGenConfig;
import com.cloud.service.entity.TableEntity;
import com.cloud.service.service.GenerateCode;
import com.cloud.service.service.GenerateCodePathConfig;

import java.util.Map;

public class ControllerCode  extends GenerateCode {

    public TableEntity autoGenEntity;


    public ControllerCode(TableEntity autoGenEntity) {
        this.autoGenEntity = autoGenEntity;
    }

    @Override
    public void generateAnInstance() {
        Map<String, Object> codeMap = GenerateCodePathConfig.getCodeMap(autoGenEntity, AutoGenConfig.controllerPackageOutPath, AutoGenConfig.entityBasePath);
        GenerateCodePathConfig.writeCode(codeMap,AutoGenConfig.controllerWritePath,GenerateCodePathConfig.getControllerPath(),"controller",autoGenEntity.getClassName()+"Controller");
    }

}
