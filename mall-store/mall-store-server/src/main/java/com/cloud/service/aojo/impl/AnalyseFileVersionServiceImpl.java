package com.cloud.service.aojo.impl;

import com.cloud.entity.PartMaster;
import com.cloud.service.aojo.AnalyseFileService;
import com.cloud.service.xsd.part.ac.BaseRootObject;
import com.cloud.service.xsd.part.ac.Part;
import com.cloud.service.xsd.part.ac.PropertyValueAssignment;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zuyunbo
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
        List<PartMaster> partMasters = new ArrayList<>();
        List<BaseRootObject> activityOrActivityMethodOrAddress1 = (List<BaseRootObject>) analyseFileService.resolvingAp242(file);
        // part
        for (BaseRootObject baseRootObject : activityOrActivityMethodOrAddress1) {
            // 在标签<part>---<version>----<partVersion>---<PropertyValueAssignment>
            Part.Versions versions = ((Part) baseRootObject).getVersions();
            List<com.cloud.service.xsd.part.ac.PartVersion> partVersion1 = versions.getPartVersion();
            for (com.cloud.service.xsd.part.ac.PartVersion partVersion2 : partVersion1) {
                List<PropertyValueAssignment> propertyValueAssignment = partVersion2.getPropertyValueAssignment();
                Object o = AnalyseFilePropertyServiceImpl.resolvingAp242((T) propertyValueAssignment);
                partMasters.add((PartMaster) o);
            }
        }
        return partMasters;
    }
}
