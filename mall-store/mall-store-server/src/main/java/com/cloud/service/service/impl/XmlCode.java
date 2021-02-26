package com.cloud.service.service.impl;

import com.cloud.service.config.AutoGenConfig;
import com.cloud.service.entity.TableEntity;
import com.cloud.service.service.GenerateCode;
import com.cloud.service.service.GenerateCodePathConfig;

import java.util.Map;

public class XmlCode extends GenerateCode {

    public TableEntity autoGenEntity;


    public XmlCode(TableEntity autoGenEntity) {
        this.autoGenEntity = autoGenEntity;
    }

    @Override
    public void generateAnInstance() {
        Map<String, Object> codeMap = GenerateCodePathConfig.getCodeMap(autoGenEntity, AutoGenConfig.entityPackageOutPath, AutoGenConfig.entityBasePath);
        GenerateCodePathConfig.writeCode(codeMap,AutoGenConfig.daoXmlWritePath,GenerateCodePathConfig.getXmlPath(),AutoGenConfig.daoBasePath,autoGenEntity.getClassName()+"Mapper.xml");
    }

}
