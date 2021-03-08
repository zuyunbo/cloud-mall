package com.cloud.service.controller;

import com.cloud.cloudbaseutil.base.controller.SaveController;
import com.cloud.cloudbaseutil.base.controller.SuperController;
import com.cloud.cloudbaseutil.base.controller.SuperSimpleController;
import com.cloud.entity.CUser;
import com.cloud.service.CUserService;
import com.cloud.service.xsd.part.ac.Uos;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;

/**
 * @Author zuyunbo
 * @Date 2021/3/2  11:34 上午
 **/
@RestController
@RequestMapping("/test")
public class testController extends SuperController<CUserService, CUser, CUser> {

    @GetMapping("/code1")
    public String generator1() {
        return "111";
    }


    @PostMapping("/import")
    public void addUser(@RequestParam("file") MultipartFile file) {

        Object xmlObject = null;

        try {

            JAXBContext context = JAXBContext.newInstance(Uos.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();

            InputStreamReader isr = new InputStreamReader(file.getInputStream(), "GBK");

            xmlObject = unmarshaller.unmarshal(isr);

        } catch (Exception e) {

            e.printStackTrace();

        }
        Uos uos = (Uos) xmlObject;






        System.out.println(uos.getHeader().getAuthor());

    }


    public static void main(String[] args) {
/*
        Object o = convertXmlFileToObject(Uos.class, "/Users/zuyunbo/202101/xsd/GWM_EC11_20210128_0832_A.STPX");
*/
        System.out.println("zhuan");
    }

    public <T> void testType(List<String> a1, List<ArrayList<String>> a2, List<T> a3, List<? extends Number> a4, List<ArrayList<String[]>> a5, Map<String, Integer> a6) {

    }


    public static Object convertXmlStrToObject(Class<?> clazz, String xmlStr) {

        Object xmlObject = null;

        try {

            JAXBContext context = JAXBContext.newInstance(clazz);

            // 进行将Xml转成对象的核心接口

            Unmarshaller unmarshal = context.createUnmarshaller();

            StringReader sr = new StringReader(xmlStr);

            xmlObject = unmarshal.unmarshal(sr);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return xmlObject;

    }


}
