package com.cloud.service.aojo.impl;

import com.cloud.entity.PartAssembly;
import com.cloud.entity.PartMaster;
import com.cloud.entity.PartVersion;
import com.cloud.service.aojo.CommonPropertyService;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * common 集成 与任何没关系
 *
 * @Author zuyunbo
 * @Date 2021/3/9  9:59 上午
 **/
public class CommonPropertyImpl<T> implements CommonPropertyService {

    private MultipartFile multipartFile = null;

    private static Map<String, Object> partAssemblyMap = new HashMap<>();
    private static Map<String, Object> partMasterMap = new HashMap<>();
    private static Map<String, Object> partVersionMap = new HashMap<>();

    private static Map<String, Object> common = new HashMap<>();




    @Override
    public Map<String, Object> getPartAssemblyMap() {
        return partAssemblyMap;
    }

    @Override
    public Map<String, Object> getPartMasterMap() {
        return partMasterMap;
    }

    @Override
    public Map<String, Object> getPartVersionMap() {
        return partVersionMap;
    }

    @Override
    public Map<String, Object> getCommonMap() {
        return common;
    }

    @Override
    public <T> void set(T bean, String fun, Object value) {
        try {
            Method method = bean.getClass().getMethod(fun, Class.forName(value.getClass().getCanonicalName()));
            method.invoke(bean, value);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static String captureName(String str) {
        // 进行字母的ascii编码前移，效率要高于截取字符串进行转换的操作
        char[] cs = str.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
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


        common.put("partAssembly", PartAssembly.class);
        common.put("Node GUID", "nodeGuid");
        common.put("Affect BOM", "affectBom");
        common.put("BKK Part Number ref.", "bkkPartNumberRef");
        common.put("Node Name", "nodeName");
        common.put("BOM line ID", "bomLineId");
        common.put("Change Number", "changeNumber");
        common.put("BoM Change Number Time Stamp", "bomChangeNumberTimeStamp");
        common.put("Quantity", "quantity");
        common.put("Position Variant Name", "positionVariantName");
        common.put("Usage Rule", "usageRule");
        common.put("BOM Line TID", "bomLineTid");
        common.put("BOM valid until date", "bomValidUntilDate");
        common.put("Release hint", "releaseHint");
        common.put("Weight type", "weightType");
        common.put("Weight", "weight");
        common.put("Weight Unit", "weightUnit");
        common.put("Build phase", "buildPhase");
        common.put("SOP date", "sopDate");
        common.put("Startup parameter", "startupParameter");
        common.put("BMW I-Level", "bmwIEvel");
        common.put("tightening element", "tighteningElement");
        common.put("Reusable", "reusable");
        common.put("Bolting category", "boltingCategory");
        common.put("Rivet nut or bolt", "rivetNutOrBolt");
        common.put("Setting force/path", "settingForcePath");
        common.put("Deviation setting force/path", "deviationSettingForcePath");
        common.put("Control method", "controlMethod");
        common.put("Tigh.self-tapping", "tighSelfTapping");
        common.put("Screw Protection", "screwProtection");
        common.put("Bolting class", "boltingClass");
        common.put("tightening torque", "tighteningTorque");
        common.put("Est.max.tight.torque", "estMaxTightTorque");
        common.put("Tightening angle", "tighteningAngle");
        common.put("Angle tolerance", "angleTolerance");
        common.put("Pre-comments", "preComments");
        common.put("Comment Service", "commentService");
        common.put("BMW location", "bmwLocation");
        common.put("label req. by law", "labelReqByLaw");
        common.put("fitment location", "fitmentLocation");
        common.put("location req. by law", "locationReqByLaw");
        common.put("G-BOM CO No.", "gBomCoNo");
        common.put("Creator", "creator");
        common.put("GWM Comment", "gwmComment");
        common.put("external part number", "externalPartNumber");
        common.put("External Part CI", "externalPartCi");
        common.put("External Part DI", "externalPartDi");
        common.put("Assembly header reference GUID", "assemblyHeaderReferenceGuid");

        //  partMaster  init
        common.put("partMasterMap", PartMaster.class);
        common.put("part number", "partNumber");
        common.put("part name (ENG)", "partName");
        common.put("Unit", "unit");
        common.put("Part Ownership Indicator", "partOwnershipIndicator");
        common.put("BMW character key", "bmwCharacterKey");
        common.put("BMW left - right characteristics", "bmwLeftRightCharacteristics");
        common.put("Symmetric Part", "symmetricPart");
        common.put("Legal Relevant", "legalRelevant");
        common.put("ESD Flag", "esdFlag");
        common.put("dangerous goods", "dangerousGoods");
        common.put("BMW DMU", "bmwDmu");
        common.put("BMW drawing hint", "bmwDrawingHint");
        common.put("All color reference", "allColorReference");
        common.put("BMW release status", "bmwReleaseStatus");
        common.put("Color Code", "colorCode");
        common.put("BMW HW/SW mark", "bmwHwSwMark");

        //   partVersion  init
        common.put("partVersion", PartVersion.class);
        common.put("part change index", "partChangeIndex");
        common.put("drawing index", "drawingIndex");
        common.put("Part TID", "partTid");
        common.put("Change Number Part Version", "changeNumberPartVersion");
        common.put("Series Disposal", "seriesDisposal");
        common.put("Aftersales disposal", "afterSalesDisposal");


    }

}
