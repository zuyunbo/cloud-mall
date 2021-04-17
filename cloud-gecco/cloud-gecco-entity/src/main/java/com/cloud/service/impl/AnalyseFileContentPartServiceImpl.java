package com.cloud.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.cloud.ac.*;
import com.cloud.entity.PartVersion;
import com.cloud.service.AnalyseFileContentService;
import com.cloud.service.AnalyseFileDataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author zuyunbo
 * @Date 2021/3/16  4:08 下午
 **/
@Service
public class AnalyseFileContentPartServiceImpl extends AnalyseFileBodyServiceImpl implements AnalyseFileContentService {
    @Override
    public List<com.cloud.entity.PartVersion> analyseFileContent(Object file) {
        AnalyseFileDataService analyseFileDataService = new AnalyseFileDataServiceImpl();
        // 取出part数据
        List<com.cloud.entity.PartVersion> partVersions = new ArrayList();
        List<BaseRootObject> activityOrActivityMethodOrAddress1 = (List<BaseRootObject>) super.resolvingAp242(file);

        for (BaseRootObject baseRootObject : activityOrActivityMethodOrAddress1) {
            // k-v值
            Map<String, String> characterStringMap = new HashMap();
            Part part = ((Part) baseRootObject);
            //取出part类型
            String partType = part.getPartTypes().getClassSelect().get(0).getValue().toString();

            // 如果version为空 证明part单独变更
            if ("piece part".equals(partType) && CollectionUtil.isEmpty(part.getVersions().getPartVersion())) {
                characterStringMap = analyseFileDataService.analysePricePart(part);
                com.cloud.entity.PartVersion partVersionReturn = new com.cloud.entity.PartVersion();
                partVersionReturn.setCharacterString(characterStringMap);
                partVersions.add(partVersionReturn);
            }

            // version和part一起变更
            if ("piece part".equals(partType) && CollectionUtil.isNotEmpty(part.getVersions().getPartVersion())) {
                // 解析每个版本里面的数据<PartVersion>
                List<PartVersion> partVersions1 = analyseFileDataService.analyseVersionPart(part);
                partVersions.addAll(partVersions1);

            }

            // assembly
            if ("assembly".equals(partType)) {
                List<com.cloud.entity.PartVersion> partVersions1 = analyseFileDataService.analyseAssemblyPart(part);
                partVersions.addAll(partVersions1);
            }

            // product
            if ("product".equals(partType)) {
                List<com.cloud.entity.PartVersion> partVersions1 = analyseFileDataService.analyseProducePart(part);
                partVersions.addAll(partVersions1);
            }


        }


        return partVersions;

    }

}