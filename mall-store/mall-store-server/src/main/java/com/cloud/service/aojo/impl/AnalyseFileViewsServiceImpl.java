package com.cloud.service.aojo.impl;

import com.cloud.entity.PartAssembly;
import com.cloud.entity.PartMaster;
import com.cloud.service.aojo.AnalyseFileService;
import com.cloud.service.xsd.part.ac.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zuyunbo
 * @Date 2021/3/9  12:55 下午
 **/
public class AnalyseFileViewsServiceImpl<T, R> implements AnalyseFileService<T> {

    private AnalyseFileService<T> analyseFileService;


    private AnalyseFileService<T> AnalyseFilePropertyServiceImpl;


    public AnalyseFileViewsServiceImpl(AnalyseFileService<T> analyseFileService, AnalyseFileService<T> analyseFilePropertyServiceImpl) {
        this.analyseFileService = analyseFileService;
        AnalyseFilePropertyServiceImpl = analyseFilePropertyServiceImpl;
    }

    @Override
    public Object resolvingAp242(T file) {
        List<PartAssembly> partMasters = new ArrayList<>();
        List<BaseRootObject> activityOrActivityMethodOrAddress1 = (List<BaseRootObject>) analyseFileService.resolvingAp242(file);
        for (BaseRootObject baseRootObject : activityOrActivityMethodOrAddress1) {
            // 在标签<part>---<version>----<partVersion>---<views>----<PartView>----<ViewOccurrenceRelationship>----<PropertyValueAssignment>
            Part.Versions versions = ((Part) baseRootObject).getVersions();
            List<com.cloud.service.xsd.part.ac.PartVersion> partVersion1 = versions.getPartVersion();
            for (com.cloud.service.xsd.part.ac.PartVersion partVersion2 : partVersion1) {
                PartVersion.Views views = partVersion2.getViews();
                List<PartView> partView = views.getPartView();
                for (PartView partView1 : partView) {
                    List<ViewOccurrenceRelationship> viewOccurrenceRelationship = partView1.getViewOccurrenceRelationship();
                    for (ViewOccurrenceRelationship viewOccurrenceRelationship1 : viewOccurrenceRelationship) {
                        List<PropertyValueAssignment> propertyValueAssignment = viewOccurrenceRelationship1.getPropertyValueAssignment();
                        Object o = AnalyseFilePropertyServiceImpl.resolvingAp242((T) propertyValueAssignment);
                        partMasters.add((PartAssembly) o);
                    }
                }
            }
        }
        return partMasters;
    }
}
