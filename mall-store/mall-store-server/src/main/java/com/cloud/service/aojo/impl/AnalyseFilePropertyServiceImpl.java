package com.cloud.service.aojo.impl;

import com.cloud.service.aojo.AnalyseFileService;
import com.cloud.service.aojo.CommonPropertyService;
import com.cloud.service.aojo.SendModelBaseService;
import com.cloud.service.xsd.part.ac.*;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zuyunbo
 * @Date 2021/3/9  12:55 下午
 **/
@Slf4j
public class AnalyseFilePropertyServiceImpl<T, R> implements AnalyseFileService<T> {

    private SendModelBaseService<T, R> sendModelBaseService;

    private CommonPropertyService commonPropertyService;

    public AnalyseFilePropertyServiceImpl(SendModelBaseService<T, R> sendModelBaseService, CommonPropertyService commonPropertyService) {
        this.sendModelBaseService = sendModelBaseService;
        this.commonPropertyService = commonPropertyService;
    }

    @Override
    public Object resolvingAp242(T file) {
        Object entityClass = sendModelBaseService.getEntityClass();
        for (PropertyValueAssignment propertyValueAssignment1 : (List<PropertyValueAssignment>) file) {
            PropertyValueAssignment.AssignedPropertyValues assignedPropertyValues = propertyValueAssignment1.getAssignedPropertyValues();
            List<PropertyValue> propertyValue = assignedPropertyValues.getPropertyValue();
            for (PropertyValue propertyValue1 : propertyValue) {
                PropertyValue.Name name = propertyValue1.getName();
                StringValue.ValueComponent valueComponent = ((StringValue) propertyValue1).getValueComponent();
                String characterString = name.getCharacterString();
                if (commonPropertyService.getPartMasterMap().containsKey(characterString)) {
                    sendModelBaseService.sendDateByPojo((R) entityClass, characterString, valueComponent.getCharacterString());
                }
                if (commonPropertyService.getPartVersionMap().containsKey(characterString)) {
                    sendModelBaseService.sendDateByPojo((R) entityClass, characterString, valueComponent.getCharacterString());
                }
                if (commonPropertyService.getPartAssemblyMap().containsKey(characterString)) {
                    sendModelBaseService.sendDateByPojo((R) entityClass, characterString, valueComponent.getCharacterString());
                }
            }
        }
        return entityClass;
    }
}
