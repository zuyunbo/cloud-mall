package com.cloud.service.controller;

import com.cloud.cloudbaseutil.base.controller.SuperController;
import com.cloud.entity.CUser;
import com.cloud.entity.PartAssembly;
import com.cloud.entity.PartMaster;
import com.cloud.entity.PartVersion;
import com.cloud.service.CUserService;
import com.cloud.service.xsd.part.ac.*;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.Class;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
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


    private static Map<String, Object> partAssemblyMap = new HashMap<>();
    private static Map<String, Object> partMasterMap = new HashMap<>();
    private static Map<String, Object> partVersionMap = new HashMap<>();


    static {
        // BOM init
        partAssemblyMap.put("partAssembly", PartAssembly.class);
        partAssemblyMap.put("Node GUID", "nodeGuid");
        partAssemblyMap.put("Affect BOM", "affectBom");
        partAssemblyMap.put("BKK Part Number ref.", "bkkPartNumberRef");
        partAssemblyMap.put("Node Name", "nodeName");
        partAssemblyMap.put("BOM line ID", "bomLineId");
        partAssemblyMap.put("Change Number", "changeNumber");
        partAssemblyMap.put("BoM Change Number Time Stamp", "bomChangeNumberTimeStamp");
        partAssemblyMap.put("Quantity", "quantity");
        partAssemblyMap.put("Position Variant Name", "positionVariantName");
        partAssemblyMap.put("Usage Rule", "usageRule");
        partAssemblyMap.put("BOM Line TID", "bomLineTid");
        partAssemblyMap.put("BOM valid until date", "bomValidUntilDate");
        partAssemblyMap.put("Release hint", "releaseHint");
        partAssemblyMap.put("Weight type", "weightType");
        partAssemblyMap.put("Weight", "weight");
        partAssemblyMap.put("Weight Unit", "weightUnit");
        partAssemblyMap.put("Build phase", "buildPhase");
        partAssemblyMap.put("SOP date", "sopDate");
        partAssemblyMap.put("Startup parameter", "startupParameter");
        partAssemblyMap.put("BMW I-Level", "bmwIEvel");
        partAssemblyMap.put("tightening element", "tighteningElement");
        partAssemblyMap.put("Reusable", "reusable");
        partAssemblyMap.put("Bolting category", "boltingCategory");
        partAssemblyMap.put("Rivet nut or bolt", "rivetNutOrBolt");
        partAssemblyMap.put("Setting force/path", "settingForcePath");
        partAssemblyMap.put("Deviation setting force/path", "deviationSettingForcePath");
        partAssemblyMap.put("Control method", "controlMethod");
        partAssemblyMap.put("Tigh.self-tapping", "tighSelfTapping");
        partAssemblyMap.put("Screw Protection", "screwProtection");
        partAssemblyMap.put("Bolting class", "boltingClass");
        partAssemblyMap.put("tightening torque", "tighteningTorque");
        partAssemblyMap.put("Est.max.tight.torque", "estMaxTightTorque");
        partAssemblyMap.put("Tightening angle", "tighteningAngle");
        partAssemblyMap.put("Angle tolerance", "angleTolerance");
        partAssemblyMap.put("Pre-comments", "preComments");
        partAssemblyMap.put("Comment Service", "commentService");
        partAssemblyMap.put("BMW location", "bmwLocation");
        partAssemblyMap.put("label req. by law", "labelReqByLaw");
        partAssemblyMap.put("fitment location", "fitmentLocation");
        partAssemblyMap.put("location req. by law", "locationReqByLaw");
        partAssemblyMap.put("G-BOM CO No.", "gBomCoNo");
        partAssemblyMap.put("Creator", "creator");
        partAssemblyMap.put("GWM Comment", "gwmComment");
        partAssemblyMap.put("external part number", "externalPartNumber");
        partAssemblyMap.put("External Part CI", "externalPartCi");
        partAssemblyMap.put("External Part DI", "externalPartDi");
        partAssemblyMap.put("Assembly header reference GUID", "assemblyHeaderReferenceGuid");

        //  partMaster  init
        partMasterMap.put("partMasterMap", PartMaster.class);
        partMasterMap.put("part number", "partNumber");
        partMasterMap.put("part name (ENG)", "partName");
        partMasterMap.put("Unit", "unit");
        partMasterMap.put("Part Ownership Indicator", "partOwnershipIndicator");
        partMasterMap.put("BMW character key", "bmwCharacterKey");
        partMasterMap.put("BMW left - right characteristics", "bmwLeftRightCharacteristics");
        partMasterMap.put("Symmetric Part", "symmetricPart");
        partMasterMap.put("Legal Relevant", "legalRelevant");
        partMasterMap.put("ESD Flag", "esdFlag");
        partMasterMap.put("dangerous goods", "dangerousGoods");
        partMasterMap.put("BMW DMU", "bmwDmu");
        partMasterMap.put("BMW drawing hint", "bmwDrawingHint");
        partMasterMap.put("All color reference", "allColorReference");
        partMasterMap.put("BMW release status", "bmwReleaseStatus");
        partMasterMap.put("Color Code", "colorCode");
        partMasterMap.put("BMW HW/SW mark", "bmwHwSwMark");

        //   partVersion  init
        partVersionMap.put("partVersion", PartVersion.class);
        partVersionMap.put("part change index", "partChangeIndex");
        partVersionMap.put("drawing index", "drawingIndex");
        partVersionMap.put("Part TID", "partTid");
        partVersionMap.put("Change Number Part Version", "changeNumberPartVersion");
        partVersionMap.put("Series Disposal", "seriesDisposal");
        partVersionMap.put("Aftersales disposal", "afterSalesDisposal");


    }


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
                        for(com.cloud.service.xsd.part.ac.PartVersion partVersion2 : partVersion1){
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
