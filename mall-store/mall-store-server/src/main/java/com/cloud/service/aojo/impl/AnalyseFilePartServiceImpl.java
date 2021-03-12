package com.cloud.service.aojo.impl;

import com.cloud.entity.*;
import com.cloud.entity.PartVersion;
import com.cloud.service.aojo.AnalyseFileService;
import com.cloud.service.aojo.CommonPropertyService;
import com.cloud.service.aojo.SendModelBaseService;
import com.cloud.service.xsd.part.ac.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.InputStreamReader;
import java.lang.Class;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static com.cloud.service.aojo.impl.CommonPropertyImpl.checkObjAllFieldsIsNull;

/**
 * 基于组装Part
 * 在标签<part>---<PropertyValueAssignment>  最简单的层级结构
 * <>主要寻找PropertyValueAssignment标签</>
 *
 * @Author zuyunbo
 * @Date 2021/3/9  12:55 下午
 **/
public class AnalyseFilePartServiceImpl<T, R> implements AnalyseFileService<T> {

    private AnalyseFileService<T> analyseFileService;


    private AnalyseFileService<T> AnalyseFilePropertyServiceImpl;


    public AnalyseFilePartServiceImpl(AnalyseFileService<T> analyseFileService, AnalyseFileService<T> analyseFilePropertyServiceImpl) {
        this.analyseFileService = analyseFileService;
        AnalyseFilePropertyServiceImpl = analyseFilePropertyServiceImpl;
    }

    @Override
    public Object resolvingAp242(T file) {
        List<PartCommon> partMasters = new ArrayList<>();
        List<BaseRootObject> activityOrActivityMethodOrAddress1 = (List<BaseRootObject>) analyseFileService.resolvingAp242(file);
        // 在标签<part>---<PropertyValueAssignment>
        for (BaseRootObject baseRootObject : activityOrActivityMethodOrAddress1) {
            // 直接取参数
            List<PropertyValueAssignment> propertyValueAssignment = ((Part) baseRootObject).getPropertyValueAssignment();
            Object o = AnalyseFilePropertyServiceImpl.resolvingAp242((T) propertyValueAssignment);
            if (!checkObjAllFieldsIsNull(o)) {
                ((PartCommon) o).setPartIdz(((Part) baseRootObject).getId().getId());
                partMasters.add((PartCommon) o);
            }
        }
        return partMasters;
    }
}
