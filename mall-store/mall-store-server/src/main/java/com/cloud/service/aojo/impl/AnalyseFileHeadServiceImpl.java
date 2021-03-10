package com.cloud.service.aojo.impl;

import com.cloud.service.aojo.AnalyseFileService;
import com.cloud.service.xsd.part.ac.Uos;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.InputStreamReader;

/**
 * 基于组装AP242头部标签的整体
 * <>UOS代表文件所有信息</>
 *
 * @Author zuyunbo
 * @Date 2021/3/9  12:55 下午
 **/
public class AnalyseFileHeadServiceImpl<T> implements AnalyseFileService<T> {

    @Override
    public Object resolvingAp242(T file) {
        Object xmlObject = null;
        MultipartFile multipartFile = (MultipartFile) file;
        try {
            JAXBContext context = JAXBContext.newInstance(Uos.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            InputStreamReader isr = new InputStreamReader(multipartFile.getInputStream(), "GBK");
            xmlObject = unmarshaller.unmarshal(isr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 最外层结构 看文档
        Uos uos = (Uos) xmlObject;
        return uos;
    }
}
