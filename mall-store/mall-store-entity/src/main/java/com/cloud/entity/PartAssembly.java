package com.cloud.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 *
 * @author 2u c1111
 * @since 1.0 2021-03-05
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Builder
@Api(description = "part_assembly")
public class PartAssembly {
	private static final long serialVersionUID = 1L;

    private Long id;





    /**
     * 影响BOM产品
     */
     @ApiModelProperty("影响BOM产品")
     private String affectBom;




    /**
     * 角度公差+/-（Deg.）
     */
     @ApiModelProperty("角度公差+/-（Deg.）")
     private String angleTolerance;




    /**
     * Assembly header reference GUID
     */
     @ApiModelProperty("Assembly header reference GUID")
     private String assemblyHeaderReferenceGuid;




    /**
     * 父级零件
     */
     @ApiModelProperty("父级零件")
     private String bkkPartNumberRef;




    /**
     * I-Level
     */
     @ApiModelProperty("I-Level")
     private String bmwIEvel;




    /**
     * 标贴位置
     */
     @ApiModelProperty("标贴位置")
     private String bmwLocation;




    /**
     * 螺接类别
     */
     @ApiModelProperty("螺接类别")
     private String boltingCategory;




    /**
     * 螺接公差等级
     */
     @ApiModelProperty("螺接公差等级")
     private String boltingClass;




    /**
     * BOM变更时间
     */
     @ApiModelProperty("BOM变更时间")
     private String bomChangeNumberTimeStamp;




    /**
     * BOM层级
     */
     @ApiModelProperty("BOM层级")
     private Integer bomLevel;




    /**
     * PV GUID
     */
     @ApiModelProperty("PV GUID")
     private String bomLineId;




    /**
     * BOM TID
     */
     @ApiModelProperty("BOM TID")
     private String bomLineTid;




    /**
     * 失效日期
     */
     @ApiModelProperty("失效日期")
     private String bomValidUntilDate;




    /**
     * build phase
     */
     @ApiModelProperty("build phase")
     private String buildPhase;




    /**
     * BOM变更单
     */
     @ApiModelProperty("BOM变更单")
     private String changeNumber;




    /**
     * 售后备注
     */
     @ApiModelProperty("售后备注")
     private String commentService;




    /**
     * 控制方法
     */
     @ApiModelProperty("控制方法")
     private String controlMethod;




    /**
     * 数据操作标识
     */
     @ApiModelProperty("数据操作标识")
     private String dataOperationIndicator;




    /**
     * 铆接力值（N）
     */
     @ApiModelProperty("铆接力值（N）")
     private String deviationSettingForcePath;




    /**
     * 最大拧紧力矩（Nm)
     */
     @ApiModelProperty("最大拧紧力矩（Nm)")
     private String estMaxTightTorque;




    /**
     * External Part CI
     */
     @ApiModelProperty("External Part CI")
     private String externalPartCi;




    /**
     * External Part DI
     */
     @ApiModelProperty("External Part DI")
     private String externalPartDi;




    /**
     * external part number
     */
     @ApiModelProperty("external part number")
     private String externalPartNumber;




    /**
     * 标贴粘贴地点
     */
     @ApiModelProperty("标贴粘贴地点")
     private String fitmentLocation;




    /**
     * G-BOM变更单
     */
     @ApiModelProperty("G-BOM变更单")
     private String gBomCoNo;




    /**
     * GWM备注
     */
     @ApiModelProperty("GWM备注")
     private String gwmComment;




    /**
     * 标贴法规要求
     */
     @ApiModelProperty("标贴法规要求")
     private String labelReqByLaw;




    /**
     * 标贴位置法规要求
     */
     @ApiModelProperty("标贴位置法规要求")
     private String locationReqByLaw;




    /**
     * Node GUID
     */
     @ApiModelProperty("Node GUID")
     private String nodeGuid;




    /**
     * Node Name
     */
     @ApiModelProperty("Node Name")
     private String nodeName;




    /**
     * F/N
     */
     @ApiModelProperty("F/N")
     private String positionVariantName;




    /**
     * 链接部位描述
     */
     @ApiModelProperty("链接部位描述")
     private String preComments;




    /**
     * 数量
     */
     @ApiModelProperty("数量")
     private Integer quantity;




    /**
     * BOM状态
     */
     @ApiModelProperty("BOM状态")
     private String releaseHint;




    /**
     * 是否可重复使用
     */
     @ApiModelProperty("是否可重复使用")
     private String reusable;




    /**
     * 铆接螺母/螺栓
     */
     @ApiModelProperty("铆接螺母/螺栓")
     private String rivetNutOrBolt;




    /**
     * 表面涂胶
     */
     @ApiModelProperty("表面涂胶")
     private String screwProtection;




    /**
     * 铆接力值设定
     */
     @ApiModelProperty("铆接力值设定")
     private String settingForcePath;




    /**
     * SOP date
     */
     @ApiModelProperty("SOP date")
     private String sopDate;




    /**
     * Startup parameter
     */
     @ApiModelProperty("Startup parameter")
     private String startupParameter;




    /**
     * 是否为自攻螺纹
     */
     @ApiModelProperty("是否为自攻螺纹")
     private String tighSelfTapping;




    /**
     * 拧紧角度（Deg.）
     */
     @ApiModelProperty("拧紧角度（Deg.）")
     private String tighteningAngle;




    /**
     * 紧固形式
     */
     @ApiModelProperty("紧固形式")
     private String tighteningElement;




    /**
     * 拧紧扭矩（Nm
     */
     @ApiModelProperty("拧紧扭矩（Nm")
     private String tighteningTorque;




    /**
     * 使用规则
     */
     @ApiModelProperty("使用规则")
     private String usageRule;




    /**
     * 重量
     */
     @ApiModelProperty("重量")
     private String weight;




    /**
     * 重量类型
     */
     @ApiModelProperty("重量类型")
     private String weightType;




    /**
     * 重量单位
     */
     @ApiModelProperty("重量单位")
     private String weightUnit;
}
