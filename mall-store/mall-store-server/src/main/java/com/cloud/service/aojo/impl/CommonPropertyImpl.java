package com.cloud.service.aojo.impl;

import com.cloud.entity.PartAssembly;
import com.cloud.entity.PartMaster;
import com.cloud.entity.PartVersion;
import com.cloud.service.aojo.CommonPropertyService;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * common
 *
 * @Author zuyunbo
 * @Date 2021/3/9  9:59 上午
 **/
public class CommonPropertyImpl<T> implements CommonPropertyService {

    private MultipartFile multipartFile = null;

    private static Map<String, Object> partAssemblyMap = new HashMap<>();
    private static Map<String, Object> partMasterMap = new HashMap<>();
    private static Map<String, Object> partVersionMap = new HashMap<>();


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

}
