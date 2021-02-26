package com.cloud.service.service.impl;

import com.cloud.service.config.AutoGenConfig;
import com.cloud.service.entity.TableEntity;
import com.cloud.service.service.GenerateCode;
import com.cloud.service.service.GenerateCodePathConfig;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author 2u
 */
@Slf4j
public class DaoCode extends GenerateCode {

    public TableEntity autoGenEntity;


    public DaoCode(TableEntity autoGenEntity) {
        this.autoGenEntity = autoGenEntity;
    }

    @Override
    public void generateAnInstance() {
        Map<String, Object> codeMap = GenerateCodePathConfig.getCodeMap(autoGenEntity, AutoGenConfig.entityPackageOutPath, AutoGenConfig.entityBasePath);
        GenerateCodePathConfig.writeCode(codeMap,AutoGenConfig.daoWritePath,GenerateCodePathConfig.getDaoPath(),AutoGenConfig.daoBasePath,autoGenEntity.getClassName()+"Mapper");
    }


}
