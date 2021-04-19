package com.cloud.service.controller;

import com.cloud.cloudbaseutil.base.controller.SuperController;
import com.cloud.entity.CUser;
import com.cloud.entity.PartAssembly;
import com.cloud.entity.PartMaster;
import com.cloud.entity.PartVersion;
import com.cloud.service.CUserService;
import com.cloud.service.aojo.impl.*;
import com.cloud.service.xsd.part.ac.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.io.File;
import java.lang.Class;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @Author zuyunbo
 * @Date 2021/3/2  11:34 上午
 **/
@RestController
@RequestMapping("/test")
public class testController extends SuperController<CUserService, CUser, CUser> {



    @Autowired
    SuperFactor superFactor;

    @GetMapping("/code1")
    public String generator1(@RequestParam("file") MultipartFile file) {
        superFactor.test(file);
        return "111";
    }


    private static Map<String, Object> partAssemblyMap = new HashMap<>();
    private static Map<String, Object> partMasterMap = new HashMap<>();
    private static Map<String, Object> partVersionMap = new HashMap<>();


    public static <T> void set(T bean, String fun, Object value) throws Exception {
        Method method = bean.getClass().getMethod(fun, Class.forName(value.getClass().getCanonicalName()));
        method.invoke(bean, value);
    }

    private static String captureName(String str) {
        // 进行字母的ascii编码前移，效率要高于截取字符串进行转换的操作
        char[] cs = str.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
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


    @PostMapping("/import2")
    public byte[] addUser2() {
        try {
            BufferedInputStream bis = null;
            bis = new BufferedInputStream(new FileInputStream(new File("/Users/zuyunbo/202101/xsd/GWM_ES21_20210202_1445_A_CODEX-82.stpx")));
            byte[] buff = new byte[bis.available()];

            int i = bis.read(buff);


            return buff;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    @PostMapping("/import1")
    public byte[] addUser1() {
        try {
            BufferedInputStream bis = null;
            bis = new BufferedInputStream(new FileInputStream(new File("/Users/zuyunbo/202101/xsd/GWM_EC12_20210329_0936_A.stpx")));
            byte[] buff = new byte[bis.available()];

            int i = bis.read(buff);


            return buff;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String ange = "GWM_EC12_20210318_1144_A.stpx";
        String substring = ange.substring(4, 8);
        System.out.println(substring);
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
        List<PartVersion> partVersions = new ArrayList<>();
        List<PartAssembly> partAssemblies = new ArrayList<>();
        List<PartMaster> partMasters = new ArrayList<>();

        if (uos != null) {
            List<DataContainer> dataContainer = uos.getDataContainer();
            for (DataContainer dataContainer1 : dataContainer) {
                AP242DataContainer activityOrActivityMethodOrAddress = (AP242DataContainer) dataContainer1;
                List<BaseRootObject> activityOrActivityMethodOrAddress1 = activityOrActivityMethodOrAddress.getActivityOrActivityMethodOrAddress();
                for (BaseRootObject baseRootObject : activityOrActivityMethodOrAddress1) {
                    if (baseRootObject instanceof Part) {
                        // 一个part里面的内容
                        PartVersion partVersion = new PartVersion();
                        PartMaster partMaster = new PartMaster();
                        PartAssembly partAssembly = new PartAssembly();
                        Part.Versions versions = ((Part) baseRootObject).getVersions();
                        List<com.cloud.service.xsd.part.ac.PartVersion> partVersion1 = versions.getPartVersion();
                        for (com.cloud.service.xsd.part.ac.PartVersion partVersion2 : partVersion1) {
                            List<PropertyValueAssignment> propertyValueAssignment = partVersion2.getPropertyValueAssignment();
                            forPartValue(partVersion, partMaster, partAssembly, propertyValueAssignment);
                        }
                        // 这里面都是新增partM的信息
                        List<PropertyValueAssignment> propertyValueAssignment = ((Part) baseRootObject).getPropertyValueAssignment();
                        forPartValue(partVersion, partMaster, partAssembly, propertyValueAssignment);


                        if (!checkObjAllFieldsIsNull(partVersion)) {
                            partVersions.add(partVersion);
                        }

                        if (!checkObjAllFieldsIsNull(partAssembly)) {
                            partAssemblies.add(partAssembly);
                        }
                        if (!checkObjAllFieldsIsNull(partMaster)) {
                            partMasters.add(partMaster);
                        }
                    }
                }
            }
        }


        System.out.println(uos.getHeader().getAuthor());

    }

    private void forPartValue(PartVersion partVersion, PartMaster partMaster, PartAssembly partAssembly, List<PropertyValueAssignment> propertyValueAssignment) {
        for (PropertyValueAssignment propertyValueAssignment1 : propertyValueAssignment) {
            PropertyValueAssignment.AssignedPropertyValues assignedPropertyValues = propertyValueAssignment1.getAssignedPropertyValues();
            List<PropertyValue> propertyValue = assignedPropertyValues.getPropertyValue();

            for (PropertyValue propertyValue1 : propertyValue) {
                PropertyValue.Name name = propertyValue1.getName();
                StringValue.ValueComponent valueComponent = ((StringValue) propertyValue1).getValueComponent();
                String characterString = name.getCharacterString();
                if (partAssemblyMap.containsKey(characterString)) {
                    try {

                        set(partAssembly, "set" + captureName(partAssemblyMap.get(characterString).toString()), valueComponent.getCharacterString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (partVersionMap.containsKey(characterString)) {
                    try {
                        set(partVersion, "set" + captureName(partVersionMap.get(characterString).toString()), valueComponent.getCharacterString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (partMasterMap.containsKey(characterString)) {
                    try {
                        set(partMaster, "set" + captureName(partMasterMap.get(characterString).toString()), valueComponent.getCharacterString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    /**
     * 判断对象中属性值是否全为空
     *
     * @param object
     * @return
     */
    public static boolean checkObjAllFieldsIsNull(Object object) {
        if (null == object) {
            return true;
        }

        try {
            for (Field f : object.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.get(object) != null && StringUtils.isNotBlank(f.get(object).toString())) {
                    return false;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }


}
