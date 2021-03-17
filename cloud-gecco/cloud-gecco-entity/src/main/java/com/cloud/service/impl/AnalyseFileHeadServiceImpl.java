package com.cloud.service.impl;


import com.cloud.ac.Uos;
import com.cloud.service.AnalyseFileCodeService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 基于组装AP242头部标签的整体
 * <>UOS代表文件所有信息</>
 *
 * @Author zuyunbo
 * @Date 2021/3/9  12:55 下午
 **/
public class AnalyseFileHeadServiceImpl implements AnalyseFileCodeService {

    @Override
    public Object resolvingAp242(Object inputStream) {
        Object xmlObject = null;
        InputStream multipartFile = (InputStream) inputStream;
        try {
            JAXBContext context = JAXBContext.newInstance(Uos.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            InputStreamReader isr = new InputStreamReader(multipartFile, "GBK");
            xmlObject = unmarshaller.unmarshal(isr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlObject;
    }


}
