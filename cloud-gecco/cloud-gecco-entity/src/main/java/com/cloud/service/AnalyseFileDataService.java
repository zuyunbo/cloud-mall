package com.cloud.service;

import com.cloud.ac.Part;
import com.cloud.entity.PartVersion;

import java.util.List;
import java.util.Map;

/**
 * @Author zuyunbo
 * @Date 2021/4/11  12:49 下午
 **/
public interface AnalyseFileDataService {

    Map<String, String> analysePricePart(Part part);

    List<PartVersion> analyseVersionPart(Part part);

    List<PartVersion> analyseProducePart(Part part);

    List<PartVersion> analyseAssemblyPart(Part part);

}
