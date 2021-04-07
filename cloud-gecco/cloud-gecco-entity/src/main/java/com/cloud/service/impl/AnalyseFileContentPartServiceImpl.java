package com.cloud.service.impl;

import com.cloud.ac.*;
import com.cloud.service.AnalyseFileContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author zuyunbo
 * @Date 2021/3/16  4:08 下午
 **/
@Service
public class AnalyseFileContentPartServiceImpl extends AnalyseFileBodyServiceImpl implements AnalyseFileContentService {

    public static Map<String, Map<String, String>> map = new HashMap();

    private static List<com.cloud.entity.PartVersion> insetPartProduct(Part part) {
        List<com.cloud.entity.PartVersion> partVersions = new ArrayList();
        Part.Versions versions = part.getVersions();
        List<PartVersion> partVersion = versions.getPartVersion();
        for (PartVersion partVersion1 : partVersion) {
            PartVersion.Views views = partVersion1.getViews();
            List<PartView> partView = views.getPartView();
            for (PartView partView1 : partView) {
                // 初始化参数
                List<ViewOccurrenceRelationship> viewOccurrenceRelationship = partView1.getViewOccurrenceRelationship();
                for (ViewOccurrenceRelationship viewOccurrenceRelationship1 : viewOccurrenceRelationship) {
                    com.cloud.entity.PartVersion partVersionReturn = new com.cloud.entity.PartVersion();
                    Map<String, String> characterStringMap = new HashMap();
                    String uid = ((SingleOccurrence) viewOccurrenceRelationship1.getRelated().getUidRef()).getUid();
                    if (map.containsKey(uid)) {
                        characterStringMap = map.get(uid);
                    }
                    characterStringMap.put("Node GUID", part.getId().getId());
                    characterStringMap.put("BOM level", "01");
                    setMapByPartLocation(characterStringMap, viewOccurrenceRelationship1.getPropertyValueAssignment());

                    // 根据文档中的字段 对应 实体类字段关系
                    if (part.getPartTypes().getClassSelect().get(0).getValue().toString().equals("product")) {
                        Map<String, String> characterStringProduct = new HashMap();
                        characterStringProduct.put("BOM level", "00");
                        characterStringProduct.put("Node GUID", part.getId().getId());
                        characterStringProduct.put("BOM line ID", characterStringMap.get("BOM line ID"));
                        characterStringProduct.put("Node Name",characterStringMap.get("Node Name"));
                        com.cloud.entity.PartVersion partVersionProduct = new com.cloud.entity.PartVersion();
                        partVersionProduct.setCharacterString(characterStringProduct);
                        partVersions.add(partVersionProduct);
                    }

                    partVersionReturn.setCharacterString(characterStringMap);
                    partVersions.add(partVersionReturn);
                }
            }
        }
        return partVersions;
    }

    // part列表
    public static Map<String, String> insertPartInstance(Part part) {
        Map<String, String> characterStringMap = new HashMap();
        setMapByPartLocation(characterStringMap, part.getPropertyValueAssignment());
        return characterStringMap;
    }


    @Override
    public List<com.cloud.entity.PartVersion> analyseFileContent(Object file) {
        // 第一种取出part下的信息
        List<com.cloud.entity.PartVersion> partVersions = new ArrayList();
        List<BaseRootObject> activityOrActivityMethodOrAddress1 = (List<BaseRootObject>) super.resolvingAp242(file);
        for (BaseRootObject baseRootObject : activityOrActivityMethodOrAddress1) {
            com.cloud.entity.PartVersion partVersionReturn = new com.cloud.entity.PartVersion();
            Map<String, String> characterStringMap = new HashMap();
            // 直接放入最外层的 PropertyValueAssignment
            Part part = ((Part) baseRootObject);
            if (part.getPartTypes().getClassSelect().get(0).getValue().toString().equals("piece part")) {
                characterStringMap = insertPartInstance(part);
                characterStringMap.put("part name (ENG)", part.getName().getCharacterString());
                characterStringMap.put("part number", part.getId().getId());
            }

            if (part.getPartTypes().getClassSelect().get(0).getValue().toString().equals("product") ||
                    part.getPartTypes().getClassSelect().get(0).getValue().toString().equals("assembly")) {
                List<com.cloud.entity.PartVersion> partVersions1 = insetPartProduct(part);
                partVersions.addAll(partVersions1);
                continue;
            }

            // 解析每个版本里面的数据<PartVersion>
            Part.Versions versions = part.getVersions();
            List<PartVersion> partVersion = versions.getPartVersion();
            for (PartVersion partVersion1 : partVersion) {
                // 如果id为空代表有引用
                if (StringUtils.isBlank(partVersion1.getId().getId())) {
                    characterStringMap.put("BOM level", "02");
                    PartVersion.Views views = partVersion1.getViews();
                    List<PartView> partViews = views.getPartView();
                    for (PartView partView : partViews) {
                        List<DefinitionBasedOccurrence> occurrence = partView.getOccurrence();
                        for (DefinitionBasedOccurrence definitionBasedOccurrence : occurrence) {
                            String id = definitionBasedOccurrence.getUid();
                            Map<String, String> refCharacterStringMap = new HashMap();
                            mapCopy(characterStringMap, refCharacterStringMap);
                            map.put(id, refCharacterStringMap);
                        }
                    }
                    continue;
                }
                // 解析<PartVersion>层的PropertyValueAssignment
                setMapByPartLocation(characterStringMap, partVersion1.getPropertyValueAssignment());
                partVersionReturn.setCharacterString(characterStringMap);
                partVersions.add(partVersionReturn);
            }
        }
        return partVersions;

    }

    private static void setMapByPartLocation(Map<String, String> characterStringMap, List<PropertyValueAssignment> propertyValueAssignment1) {
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