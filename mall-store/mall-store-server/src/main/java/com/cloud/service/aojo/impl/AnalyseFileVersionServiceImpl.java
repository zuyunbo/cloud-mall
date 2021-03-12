package com.cloud.service.aojo.impl;

import com.cloud.entity.Common;
import com.cloud.entity.PartCommon;
import com.cloud.entity.PartMaster;
import com.cloud.service.aojo.AnalyseFileService;
import com.cloud.service.xsd.part.ac.BaseRootObject;
import com.cloud.service.xsd.part.ac.Part;
import com.cloud.entity.PartVersion;
import com.cloud.service.xsd.part.ac.PropertyValueAssignment;

import java.util.ArrayList;
import java.util.List;

import static com.cloud.service.aojo.impl.CommonPropertyImpl.checkObjAllFieldsIsNull;

/**
 * 基于组装Part
 * 在标签<part>---<version>----<partVersion>---<PropertyValueAssignment>  在partVersion里寻找关系 对应实体PartVersion表
 * <>主要寻找PropertyValueAssignment标签</>
 *
 * @Author ynBo 2u
 * @Date 2021/3/9  12:55 下午
 **/
public class AnalyseFileVersionServiceImpl<T, R> implements AnalyseFileService<T> {

    private AnalyseFileService<T> analyseFileService;


    private AnalyseFileService<T> AnalyseFilePropertyServiceImpl;


    public AnalyseFileVersionServiceImpl(AnalyseFileService<T> analyseFileService, AnalyseFileService<T> analyseFilePropertyServiceImpl) {
        this.analyseFileService = analyseFileService;
        AnalyseFilePropertyServiceImpl = analyseFilePropertyServiceImpl;
    }

    @Override
    public Object resolvingAp242(T file) {
        // 用于返回PO新增
        List<PartCommon> partVersions = new ArrayList<>();

        // 解析文件详细的信息 （理解为PartVersion数据）
        List<BaseRootObject> activityOrActivityMethodOrAddress1 = (List<BaseRootObject>) analyseFileService.resolvingAp242(file);
        for (BaseRootObject baseRootObject : activityOrActivityMethodOrAddress1) {
            // 在标签<part>---<version>----<partVersion>---<PropertyValueAssignment>
            Part.Versions versions = ((Part) baseRootObject).getVersions();
            List<com.cloud.service.xsd.part.ac.PartVersion> partVersion1 = versions.getPartVersion();
            for (com.cloud.service.xsd.part.ac.PartVersion partVersion2 : partVersion1) {
                List<PropertyValueAssignment> propertyValueAssignment = partVersion2.getPropertyValueAssignment();
                // 根据文档中的字段 对应 实体类字段关系
                Object o = AnalyseFilePropertyServiceImpl.resolvingAp242((T) propertyValueAssignment);
                if(!checkObjAllFieldsIsNull(o)){
                    ((PartCommon) o).setPartIdz(((Part) baseRootObject).getId().getId());
                    partVersions.add((PartCommon) o);
                }
            }
        }
        return partVersions;
    }
}
