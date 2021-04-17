package com.cloud.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.cloud.ac.*;
import com.cloud.service.AnalyseCommonUtil;
import com.cloud.service.AnalyseFileDataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zuyunbo
 * @Date 2021/4/11  12:51 下午
 **/
public class AnalyseFileDataServiceImpl extends AnalyseCommonUtil implements AnalyseFileDataService {

    public static Map<String, Map<String, String>> PART = new HashMap();
    public static Map<String, Map<String, String>> assembly = new HashMap();
    public static Map<String, Map<String, String>> product = new HashMap();


    @Override
    public Map<String, String> analysePricePart(Part part) {
        Map<String, String> characterStringMap = new HashMap();
        characterStringMap.put("part name (ENG)", part.getName().getCharacterString());
        characterStringMap.put("part number", part.getId().getId());
        super.setMapByPartLocation(characterStringMap, part.getPropertyValueAssignment());
        return characterStringMap;
    }

    @Override
    public List<com.cloud.entity.PartVersion> analyseVersionPart(Part part) {
        // 初始户参数
        List<com.cloud.entity.PartVersion> partVersions = new ArrayList();
        Part.Versions versions = part.getVersions();
        List<PartVersion> partVersion = versions.getPartVersion();

        if (CollectionUtil.isEmpty(partVersion)) {
            return null;
        }

        // 获取part的数据
        Map<String, String> stringStringMap = this.analysePricePart(part);
        com.cloud.entity.PartVersion partVersionReturn = new com.cloud.entity.PartVersion();

        for (PartVersion partVersion1 : partVersion) {
            if (StringUtils.isBlank(partVersion1.getId().getId())) {
                partIsRank(stringStringMap, partVersion1, partVersions);
                stringStringMap.put("BOM level", "02");
                continue;
            }
            // 解析<PartVersion>层的PropertyValueAssignment
            stringStringMap.put("Common Type", "version");
            setMapByPartLocation(stringStringMap, partVersion1.getPropertyValueAssignment());
            partVersionReturn.setCharacterString(stringStringMap);
            partVersions.add(partVersionReturn);
        }
        return partVersions;
    }

    @Override
    public List<com.cloud.entity.PartVersion> analyseAssemblyPart(Part part) {
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
                    Map<String, String> characterStringMap = new HashMap();
                    com.cloud.entity.PartVersion partVersionReturn = new com.cloud.entity.PartVersion();
                    String uid = ((SingleOccurrence) viewOccurrenceRelationship1.getRelated().getUidRef()).getUid();

                    if (PART.containsKey(uid)) {
                        characterStringMap = PART.get(uid);
                    }

                    if (!CollectionUtils.isEmpty(partView1.getOccurrence())) {
                        String uid1 = partView1.getOccurrence().get(0).getUid();
                        if (StringUtils.isNotEmpty(uid1)) {
                            characterStringMap.put("BOM level", "01");
                            if (product.containsKey(uid1)) {
                                Map<String, String> stringStringMap = product.get(uid1);
                                characterStringMap.put("Node GUID", stringStringMap.get("Node GUID"));
                            }
                        }
                    }
                    characterStringMap.put("Common Type", "assembly");
                    setMapByPartLocation(characterStringMap, viewOccurrenceRelationship1.getPropertyValueAssignment());

                    partVersionReturn.setCharacterString(characterStringMap);
                    partVersions.add(partVersionReturn);

                }
            }
        }
        return partVersions;
    }

    @Override
    public List<com.cloud.entity.PartVersion> analyseProducePart(Part part) {
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
                    Map<String, String> characterStringMap = new HashMap();
                    com.cloud.entity.PartVersion partVersionReturn = new com.cloud.entity.PartVersion();
                    com.cloud.entity.PartVersion partVersionReturn1 = new com.cloud.entity.PartVersion();

                    String uid = ((SingleOccurrence) viewOccurrenceRelationship1.getRelated().getUidRef()).getUid();

                    if (CollectionUtil.isNotEmpty(viewOccurrenceRelationship1.getPropertyValueAssignment())) {
                        setMapByPartLocation(characterStringMap, viewOccurrenceRelationship1.getPropertyValueAssignment());
                    }
                    Map<String, String> characterStringProduct = new HashMap();
                    characterStringProduct.put("Common Type", "produce");
                    characterStringProduct.put("BOM level", "00");
                    characterStringProduct.put("Node GUID", part.getId().getId());
                    characterStringProduct.put("BOM line ID", characterStringMap.get("BOM line ID"));
                    characterStringProduct.put("Node Name", characterStringMap.get("Node Name"));
                    partVersionReturn1.setCharacterString(characterStringProduct);
                    partVersions.add(partVersionReturn1);

                    if (CollectionUtil.isNotEmpty(viewOccurrenceRelationship1.getPropertyValueAssignment())) {
                        setMapByPartLocation(characterStringMap, viewOccurrenceRelationship1.getPropertyValueAssignment());
                        characterStringMap.put("Node GUID", part.getId().getId());
                        characterStringMap.put("BOM level", "01");
                        characterStringMap.put("Common Type", "assembly");
                        partVersionReturn.setCharacterString(characterStringMap);
                        partVersions.add(partVersionReturn);
                    }

                    product.put(uid, characterStringProduct);

                }
            }
        }
        return partVersions;
    }


    /**
     * 如果partVersion id为空，证明有引用关系
     *
     * @param stringStringMap part属性
     * @param partVersion     partVersion属性
     */
    public void partIsRank(Map<String, String> stringStringMap, PartVersion partVersion, List<com.cloud.entity.PartVersion> partVersions) {
        PartVersion.Views views = partVersion.getViews();
        List<PartView> partViews = views.getPartView();
        for (PartView partView : partViews) {
            List<DefinitionBasedOccurrence> occurrence = partView.getOccurrence();
            for (DefinitionBasedOccurrence definitionBasedOccurrence : occurrence) {
                String id = definitionBasedOccurrence.getUid();
                Map<String, String> refCharacterStringMap = new HashMap();
                mapCopy(stringStringMap, refCharacterStringMap);
                PART.put(id, refCharacterStringMap);
            }

            if (CollectionUtil.isNotEmpty(partView.getViewOccurrenceRelationship())) {
                for (ViewOccurrenceRelationship viewOccurrenceRelationship : partView.getViewOccurrenceRelationship()) {
                    com.cloud.entity.PartVersion partVersionReturn = new com.cloud.entity.PartVersion();
                    String uid = ((SingleOccurrence) viewOccurrenceRelationship.getRelated().getUidRef()).getUid();
                    if (PART.containsKey(uid)) {
                        Map<String, String> characterStringMap = new HashMap();
                        characterStringMap = PART.get(uid);
                        characterStringMap.put("Common Type", "assembly");
                        characterStringMap.put("BOM level", "01");
                        setMapByPartLocation(characterStringMap, viewOccurrenceRelationship.getPropertyValueAssignment());
                        partVersionReturn.setCharacterString(characterStringMap);
                        partVersions.add(partVersionReturn);
                    }
                }

            }
        }
    }

}
