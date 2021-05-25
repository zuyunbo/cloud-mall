package com.cloud.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author zuyunbo
 * @Date 2021/4/11  12:52 下午
 **/
public abstract class AnalyseCommonUtil {

    public  void setMapByPartLocation(Map<String, String> characterStringMap, List<PropertyValueAssignment> propertyValueAssignment1) {
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
                characterStringMap.put(characterString, value);
            }
        }
    }

    public static void mapCopy(Map paramsMap, Map resultMap) {
        if (resultMap == null) {
            resultMap = new HashMap();
        }
        if (paramsMap == null) {
            return;
        }

        Iterator it = paramsMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            resultMap.put(key, paramsMap.get(key) != null ? paramsMap.get(key) : "");

        }
    }
}
