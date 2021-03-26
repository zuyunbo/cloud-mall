package com.cloud.service;

import com.cloud.entity.PartVersion;

import java.util.List;

/**
 * @Author zuyunbo
 * @Date 2021/3/16  4:08 下午
 **/
public interface AnalyseFileContentService {


    List<PartVersion> analyseFileContent(Object file);
}
