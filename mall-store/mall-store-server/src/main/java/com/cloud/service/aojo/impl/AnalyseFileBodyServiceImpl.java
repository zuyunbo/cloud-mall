package com.cloud.service.aojo.impl;

import com.cloud.service.aojo.AnalyseFileService;
import com.cloud.service.xsd.part.ac.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于组装AP242切割部分
 * <>用于寻找主要信息 ----主要切割标签为(Part)的信息</>
 *
 * @Author zuyunbo
 * @Date 2021/3/9  12:55 下午
 **/
@Slf4j
public class AnalyseFileBodyServiceImpl<T> implements AnalyseFileService<T> {

    private AnalyseFileService<T> analyseFileService;

    public AnalyseFileBodyServiceImpl(AnalyseFileService<T> analyseFileService) {
        this.analyseFileService = analyseFileService;
    }

    @Override
    public Object resolvingAp242(T file) {
        List<BaseRootObject> activityOrActivityMethodOrAddress1 = new ArrayList<>();
        Uos uos = (Uos) analyseFileService.resolvingAp242(file);

        if (uos == null) {
            log.error("文件解析错误生成失败 {}", "SendModelByPartMasterImpl.class");
        }
        assert uos != null;
        List<DataContainer> dataContainer = uos.getDataContainer();
        for (DataContainer dataContainer1 : dataContainer) {
            AP242DataContainer activityOrActivityMethodOrAddress = (AP242DataContainer) dataContainer1;
            List<BaseRootObject> activityOrActivityMethodOrAddress2 = activityOrActivityMethodOrAddress.getActivityOrActivityMethodOrAddress();
            for (BaseRootObject baseRootObject : activityOrActivityMethodOrAddress2) {
                if (baseRootObject instanceof Part) {
                    activityOrActivityMethodOrAddress1.add(baseRootObject);
                }
            }
        }
        // 中间结构取part信息
        return activityOrActivityMethodOrAddress1;
    }
}
