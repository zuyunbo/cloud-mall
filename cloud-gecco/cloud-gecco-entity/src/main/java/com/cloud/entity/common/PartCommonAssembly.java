package com.cloud.entity.common;

import io.swagger.annotations.Api;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author 2u c1111
 * @since 1.0 2021-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Api(description = "part_common")
public class PartCommonAssembly {

    private Long id;

    /**
     * 影响BOM产品
     */
    private String affectBom;

    /**
     * 角度公差+/-（Deg.）
     */
    private String angleTolerance;


    /**
     * Assembly header reference GUID
     */
    private String assemblyHeaderReferenceGuid;


    /**
     * 父级零件
     */
    private String bkkPartNumberRef;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 初始变更
     */
    private String initialChange;

    /**
     * G-bom备注
     */
    private String gwmComment;


    /**
     * I-Level
     */
    private String bmwIEvel;




    /**
     * 标贴位置
     */
    private String bmwLocation;


    /**
     * 螺接类别
     */
    private String boltingCategory;


    /**
     * 螺接公差等级
     */
    private String boltingClass;


    /**
     * BOM变更时间
     */
    private String bomChangeNumberTimeStamp;


    /**
     * BOM层级
     */
    private Integer bomLevel;


    /**
     * PV GUID
     */
    private String bomLineId;


    /**
     * BOM TID
     */
    private String bomLineTid;


    /**
     * 失效日期
     */
    private String bomValidUntilDate;


    /**
     * build phase
     */
    private String buildPhase;


    /**
     * BOM变更单
     */
    private String changeNumber;



    /**
     * 售后备注
     */
    private String commentService;


    /**
     * 控制方法
     */
    private String controlMethod;



    /**
     * DIAGNOSIS_ADDRESS
     */
    private String diagnosisAddress;


    /**
     * 数据操作标识
     */
    private String dataOperationIndicator;


    /**
     * 铆接力值（N）
     */
    private String deviationSettingForcePath;

    /**
     * 最大拧紧力矩（Nm)
     */
    private String estMaxTightTorque;


    /**
     * External Part CI
     */
    private String externalPartCi;


    /**
     * External Part DI
     */
    private String externalPartDi;


    /**
     * external part number
     */
    private String externalPartNumber;


    /**
     * 标贴粘贴地点
     */
    private String fitmentLocation;


    /**
     * G-BOM变更单
     */
    private String gBomCoNo;


    /**
     * 标贴法规要求
     */
    private String labelReqByLaw;




    /**
     * 标贴位置法规要求
     */
    private String locationReqByLaw;


    /**
     * Node GUID
     */
    private String nodeGuid;


    /**
     * Node Name
     */
    private String nodeName;



    /**
     * F/N
     */
    private String positionVariantName;


    /**
     * 链接部位描述
     */
    private String preComments;


    /**
     * 数量
     */
    private String quantity;


    /**
     * BOM状态
     */
    private String releaseHint;


    /**
     * 是否可重复使用
     */
    private String reusable;


    /**
     * 铆接螺母/螺栓
     */
    private String rivetNutOrBolt;


    /**
     * 表面涂胶
     */
    private String screwProtection;



    /**
     * 铆接力值设定
     */
    private String settingForcePath;


    /**
     * SOP date
     */
    private String sopDate;


    /**
     * Startup parameter
     */
    private String startupParameter;




    /**
     * 是否为自攻螺纹
     */
    private String tighSelfTapping;


    /**
     * 拧紧角度（Deg.）
     */
    private String tighteningAngle;


    /**
     * 紧固形式
     */
    private String tighteningElement;


    /**
     * 拧紧扭矩（Nm
     */
    private String tighteningTorque;


    /**
     * 使用规则
     */
    private String usageRule;


    /**
     * 重量单位
     */
    private String weightUnit;

    /**
     * 时间
     */
    private String receivedDate;


    private String partIdz;

}
