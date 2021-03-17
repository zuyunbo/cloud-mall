package com.cloud.service.impl;

import com.cloud.ac.*;
import com.cloud.entity.PartInstance;
import com.cloud.entity.PartPropertyValueAssignment;
import com.cloud.service.AnalyseFileContentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zuyunbo
 * @Date 2021/3/16  4:08 下午
 **/
public class AnalyseFileContentPartServiceImpl extends AnalyseFileBodyServiceImpl implements AnalyseFileContentService{


    @Override
    public void analyseFileContent(Object file) {
        // 初始化Part
        List<PartInstance> partInstances = new ArrayList<>();

        // 第一种取出part下的信息
        List<BaseRootObject> activityOrActivityMethodOrAddress1 = (List<BaseRootObject>) super.resolvingAp242(file);
        for (BaseRootObject baseRootObject : activityOrActivityMethodOrAddress1) {
            PartInstance partInstance = new PartInstance();
            PartPropertyValueAssignment partPropertyValueAssignment = new PartPropertyValueAssignment();
            Map<String,String> characterStringMap = new HashMap<>();
            List<com.cloud.entity.PartVersion> partVersions = new ArrayList<>();
            // 直接放入最外层的 PropertyValueAssignment
            setMapByPartLocation(characterStringMap, ((Part) baseRootObject).getPropertyValueAssignment());
            partPropertyValueAssignment.setCharacterString(characterStringMap);
            partInstance.setPropertyValueAssignment(partPropertyValueAssignment);
            // 解析每个版本里面的数据<PartVersion>
            com.cloud.entity.PartVersion partVersion2 = new com.cloud.entity.PartVersion();
            Part.Versions versions = ((Part) baseRootObject).getVersions();
            List<PartVersion> partVersion = versions.getPartVersion();
            for (PartVersion partVersion1 : partVersion) {
                // 解析<PartVersion>层的PropertyValueAssignment
                PartPropertyValueAssignment partPropertyValueAssignment2 = new PartPropertyValueAssignment();
                Map<String,String> characterStringMap2 = new HashMap<>();
                setMapByPartLocation(characterStringMap2, partVersion1.getPropertyValueAssignment());
                partPropertyValueAssignment2.setCharacterString(characterStringMap2);
                partVersion2.setPropertyValueAssignment(partPropertyValueAssignment2);
                partVersions.add(partVersion2);
                partInstance.setPartVersion(partVersions);
                // 解析<PartVersionRelationship>层的 PropertyValueAssignment 其中有继承的数据
                com.cloud.entity.PartVersionRelationship partVersionRelationship = new  com.cloud.entity.PartVersionRelationship();
                PartVersion.Views views = partVersion1.getViews();
                List<PartView> partView = views.getPartView();
                for (PartView partView1 : partView) {
                    // 初始化参数
                    PartPropertyValueAssignment partPropertyValueAssignment3 = new PartPropertyValueAssignment();
                    Map<String,String> characterStringMap3 = new HashMap<>();
                    List<ViewOccurrenceRelationship> viewOccurrenceRelationship = partView1.getViewOccurrenceRelationship();
                    for (ViewOccurrenceRelationship viewOccurrenceRelationship1 : viewOccurrenceRelationship) {
                        // 根据文档中的字段 对应 实体类字段关系
                        setMapByPartLocation(characterStringMap3,viewOccurrenceRelationship1.getPropertyValueAssignment());
                        partPropertyValueAssignment3.setCharacterString(characterStringMap3);
                    }
                    partVersionRelationship.setPropertyValueAssignment(partPropertyValueAssignment3);
                }
                partVersion2.setPartVersionRelationship(partVersionRelationship);
            }
            partInstances.add(partInstance);
        }
        System.out.println("111");

    }

    private void setMapByPartLocation(Map<String, String> characterStringMap, List<PropertyValueAssignment> propertyValueAssignment1) {
        for (PropertyValueAssignment propertyValueAssignment2 : propertyValueAssignment1) {
            PropertyValueAssignment.AssignedPropertyValues assignedPropertyValues = propertyValueAssignment2.getAssignedPropertyValues();
            List<PropertyValue> propertyValue = assignedPropertyValues.getPropertyValue();
            for (PropertyValue propertyValue1 : propertyValue) {
                PropertyValue.Name name = propertyValue1.getName();
                StringValue.ValueComponent valueComponent = ((StringValue) propertyValue1).getValueComponent();
                // key值
                String characterString = name.getCharacterString();
                // value值
                String value = valueComponent.getCharacterString();
                characterStringMap.put(characterString,value);
            }
        }
    }

}
