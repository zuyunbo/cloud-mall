package com.cloud.service.service.impl;

import com.cloud.service.config.AutoGenConfig;
import com.cloud.service.entity.TableEntity;
import com.cloud.service.service.GenerateCode;
import com.cloud.service.service.GenerateCodePathConfig;

import java.util.Map;

public class ParamCode extends GenerateCode {

    public TableEntity autoGenEntity;


    public ParamCode(TableEntity autoGenEntity) {
        this.autoGenEntity = autoGenEntity;
    }

    /**
     * 生成代码
     */
    @Override
    public void generateAnInstance() {
        Map<String, Object> codeMap = GenerateCodePathConfig.getCodeMap(autoGenEntity, AutoGenConfig.entityPackageOutPath, AutoGenConfig.paramBasePath);
        GenerateCodePathConfig.writeCode(codeMap,AutoGenConfig.ParamWritePath,GenerateCodePathConfig.getEntityPath(),"param",autoGenEntity.getClassName()+"Param");
    }

}
