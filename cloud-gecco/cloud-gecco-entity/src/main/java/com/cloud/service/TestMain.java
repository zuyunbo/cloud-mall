package com.cloud.service;

import com.cloud.ac.Part;
import com.cloud.entity.PartVersion;
import com.cloud.service.impl.AnalyseFileContentPartServiceImpl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zuyunbo
 * @Date 2021/3/16  4:27 下午
 **/
public class TestMain {

    private static Map<String, Object> common = new HashMap<>();


    public static void main(String[] args) throws FileNotFoundException {
        BufferedInputStream bis = null;
        bis = new BufferedInputStream(new FileInputStream(new File("/Users/zuyunbo/202101/xsd/GWM_ES21_20210202_1445_A_CODEX-82.stpx")));
        AnalyseFileContentPartServiceImpl analyseFileContentPartService = new AnalyseFileContentPartServiceImpl();
        List<PartVersion> partVersions = analyseFileContentPartService.analyseFileContent(bis);
        List<PartCommon> list = new ArrayList<>();
        for (PartVersion partVersion : partVersions) {
            Map<String, String> characterString = partVersion.getCharacterString();
            PartCommon partCommon = new PartCommon();
            for (String key : characterString.keySet()) {
                System.out.println(key);
                set(partCommon, "set" + captureName(common.get(key).toString()), characterString.get(key));

            }
            list.add(partCommon);
        }
        System.out.println("123");

    }

    public static <T> void set(T bean, String fun, Object value) {
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
        common.put("Data Operation Indicator", "dataOperationIndicator");
        common.put("Release hint", "releaseHint");
        common.put("Weight type", "weightType");
        common.put("Weight", "weight");
        common.put("Weight Unit", "weightUnit");
        common.put("Build phase", "buildPhase");
        common.put("SOP date", "sopDate");
        common.put("Startup parameter", "startupParameter");
        common.put("BMW I-Level", "bmwIEvel");
        common.put("Tightening element", "tighteningElement");
        common.put("Reusable", "reusable");
        common.put("Bolting category", "boltingCategory");
        common.put("Rivet nut or bolt", "rivetNutOrBolt");
        common.put("Setting force/path", "settingForcePath");
        common.put("Deviation setting force/path", "deviationSettingForcePath");
        common.put("Control method", "controlMethod");
        common.put("Tigh.self-tapping", "tighSelfTapping");
        common.put("Screw Protection", "screwProtection");
        common.put("Bolting class", "boltingClass");
        common.put("Tightening torque", "tighteningTorque");
        common.put("Est.max.tight.torque", "estMaxTightTorque");
        common.put("Tightening angle", "tighteningAngle");
        common.put("Angle tolerance", "angleTolerance");
        common.put("Pre-comments", "preComments");
        common.put("Comment Service", "commentService");
        common.put("BMW location", "bmwLocation");
        common.put("Label req. by law", "labelReqByLaw");
        common.put("Fitment location", "fitmentLocation");
        common.put("Location req. by law", "locationReqByLaw");
        common.put("G-BOM CO No.", "gBomCoNo");
        common.put("Creator", "creator");
        common.put("GWM Comment", "gwmComment");
        common.put("external part number", "externalPartNumber");
        common.put("External Part CI", "externalPartCi");
        common.put("External Part DI", "externalPartDi");
        common.put("Assembly header reference GUID", "assemblyHeaderReferenceGuid");
        common.put("Part change index","partChangeIndex");

        //  partMaster  init
        common.put("part number", "partNumber");
        common.put("part name (ENG)", "partName");
        common.put("Unit", "unit");
        common.put("Part Ownership Indicator", "partOwnershipIndicator");
        common.put("BMW character key", "bmwCharacterKey");
        common.put("BMW left - right characteristics", "bmwLeftRightCharacteristics");
        common.put("Symetric Part", "symmetricPart");
        common.put("Legal Relevant", "legalRelevant");
        common.put("ESD flag", "esdFlag");
        common.put("Dangerous goods flag", "dangerousGoods");
        common.put("BMW DMU", "bmwDmu");
        common.put("BMW drawing hint", "bmwDrawingHint");
        common.put("All color reference", "allColorReference");
        common.put("BMW release status", "bmwReleaseStatus");
        common.put("Color Code", "colorCode");
        common.put("BMW HW/SW mark", "bmwHwSwMark");

        //   partVersion  init
        common.put("part change index", "partChangeIndex");
        common.put("Drawing index", "drawingIndex");
        common.put("Part TID", "partTid");
        common.put("Change Number Part Version", "changeNumberPartVersion");
        common.put("Series Disposal", "seriesDisposal");
        common.put("Aftersales disposal", "afterSalesDisposal");


    }


}
