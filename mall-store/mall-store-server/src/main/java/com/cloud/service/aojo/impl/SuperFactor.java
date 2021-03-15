package com.cloud.service.aojo.impl;


import com.cloud.entity.PartCommon;
import com.cloud.mapper.PartCommonMapper;
import com.cloud.mapper.PartMasterMapper;
import com.cloud.service.aojo.AnalyseFileService;
import org.apache.commons.collections.CollectionUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zuyunbo
 * @Date 2021/3/9  4:14 下午
 **/
@Service("SuperFactor")
public class SuperFactor<T, R> {


    @Autowired
    PartCommonMapper partMasterMapper;


    public void test(MultipartFile file) {

        List<PartCommon> result = new ArrayList();
        // BOM
        AnalyseFileService<MultipartFile> sendModelByPartAssM = new AnalyseFilePropertyServiceImpl<MultipartFile, R>(new SendModelByPartAssmelyImpl(),
                new CommonPropertyImpl<MultipartFile>());

        AnalyseFileService<MultipartFile> analyseFileService = new AnalyseFileViewsServiceImpl(
                new AnalyseFileBodyServiceImpl<MultipartFile>(new AnalyseFileHeadServiceImpl()),
                sendModelByPartAssM);
        List<PartCommon> commons = (List<PartCommon>) analyseFileService.resolvingAp242(file);

        // M_V
        AnalyseFileService<MultipartFile> sendMV = new AnalyseFilePropertyServiceImpl<MultipartFile, R>(new SendModelByPartVersionImpl(),
                new CommonPropertyImpl<MultipartFile>());


        AnalyseFileService<MultipartFile> analyseFileService1 = new AnalyseFileVersionServiceImpl(
                new AnalyseFileBodyServiceImpl<MultipartFile>(new AnalyseFileHeadServiceImpl()),
                sendMV);
        List<PartCommon> commons1 = (List<PartCommon>) analyseFileService1.resolvingAp242(file);


        AnalyseFileService<MultipartFile> sendMP = new AnalyseFilePropertyServiceImpl<MultipartFile, R>(new SendModelByPartMasterImpl(),
                new CommonPropertyImpl<MultipartFile>());

        AnalyseFileService<MultipartFile> analyseFileService2 = new AnalyseFilePartServiceImpl(
                new AnalyseFileBodyServiceImpl<MultipartFile>(new AnalyseFileHeadServiceImpl()),
                sendMP);
        List<PartCommon> commons2 = (List<PartCommon>) analyseFileService2.resolvingAp242(file);


        if (CollectionUtils.isNotEmpty(commons)) {
            result.addAll(commons);
        }
        if (CollectionUtils.isNotEmpty(commons1) && CollectionUtils.isNotEmpty(commons2)) {
            for (PartCommon common : commons1) {
                for (PartCommon common1 : commons2) {
                    if (common1.getPartIdz().equals(common.getPartIdz())) {
                        result.add((PartCommon) CommonPropertyImpl.combineSydwCore(common1, common));
                    }
                }
            }
        } else if (CollectionUtils.isNotEmpty(commons1)) {
            result.addAll(commons1);
        } else if (CollectionUtils.isNotEmpty(commons2)) {
            result.addAll(commons2);
        }


        for (PartCommon partCommon : result) {
            partMasterMapper.saveByEntity(partCommon);
        }

    }


}
