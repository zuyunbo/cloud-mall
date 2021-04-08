package com.cloud.service;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author 2u c1111
 * @since 1.0 2021-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Api(description = "part_common")
public class PartCommon {

    private Long id;


    /**
     * 影响BOM产品
     */
    private String affectBom;


    /**
     * 售后旧件处理
     */
    private String afterSalesDisposal;


    /**
     * 本色件号
     */
    private String allColorReference;


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
     * 关键字符
     */
    private String bmwCharacterKey;


    /**
     * 参考数模的零件号
     */
    private String bmwDmu;


    /**
     * 参考图纸的零件号
     */
    private String bmwDrawingHint;


    /**
     * 硬件/软件标识
     */
    private String bmwHwSwMark;


    /**
     * I-Level
     */
    private String bmwIEvel;


    /**
     * 左右件标识
     */
    private String bmwLeftRightCharacteristics;


    /**
     * 标贴位置
     */
    private String bmwLocation;


    /**
     * 零件状态
     */
    private String bmwReleaseStatus;


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
    private String bomLevel;


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
     * 零件变更单
     */
    private String changeNumberPartVersion;


    /**
     * 颜色代码
     */
    private String colorCode;


    /**
     * 售后备注
     */
    private String commentService;


    /**
     * 控制方法
     */
    private String controlMethod;


    /**
     * 危险品标识
     */
    private String dangerousGoods;

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
     * 图纸版本
     */
    private String drawingIndex;


    /**
     * 防静电标识
     */
    private String esdFlag;


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
     * 法规标识
     */
    private String legalRelevant;


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
     * 零件版本
     */
    private String partChangeIndex;


    /**
     * 零件名称
     */
    private String partName;


    /**
     * 零件编号
     */
    private String partNumber;


    /**
     * 零件归属标识
     */
    private String partOwnershipIndicator;


    /**
     * 零件目标生效时间
     */
    private String partTid;


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
     * 生产旧件处理
     */
    private String seriesDisposal;


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
     * 对称件
     */
    private String symmetricPart;


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
     * 数量单位
     */
    private String unit;


    /**
     * 使用规则
     */
    private String usageRule;


    /**
     * 重量
     */
    private String weight;


    /**
     * 重量类型
     */
    private String weightType;
    /**
     * 重量单位
     */
    private String weightUnit;

    /**
     * 时间
     */
    private String receivedDate;


    private String partIdz;

    private String commonType;

}
