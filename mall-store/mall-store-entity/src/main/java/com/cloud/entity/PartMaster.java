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
@Api(description = "part_master")
public class PartMaster {
	private static final long serialVersionUID = 1L;

    private Long id;





    /**
     * 本色件号
     */
     @ApiModelProperty("本色件号")
     private String allColorReference;




    /**
     * 关键字符
     */
     @ApiModelProperty("关键字符")
     private String bmwCharacterKey;




    /**
     * 参考数模的零件号
     */
     @ApiModelProperty("参考数模的零件号")
     private String bmwDmu;




    /**
     * 参考图纸的零件号
     */
     @ApiModelProperty("参考图纸的零件号")
     private String bmwDrawingHint;




    /**
     * 硬件/软件标识
     */
     @ApiModelProperty("硬件/软件标识")
     private String bmwHwSwMark;




    /**
     * 左右件标识
     */
     @ApiModelProperty("左右件标识")
     private String bmwLeftRightCharacteristics;




    /**
     * 零件状态
     */
     @ApiModelProperty("零件状态")
     private String bmwReleaseStatus;




    /**
     * 颜色代码
     */
     @ApiModelProperty("颜色代码")
     private String colorCode;




    /**
     * 危险品标识
     */
     @ApiModelProperty("危险品标识")
     private String dangerousGoods;




    /**
     * 防静电标识
     */
     @ApiModelProperty("防静电标识")
     private String esdFlag;




    /**
     * 法规标识
     */
     @ApiModelProperty("法规标识")
     private String legalRelevant;




    /**
     * 零件名称
     */
     @ApiModelProperty("零件名称")
     private String partName;




    /**
     * 零件编号
     */
     @ApiModelProperty("零件编号")
     private String partNumber;




    /**
     * 零件归属标识
     */
     @ApiModelProperty("零件归属标识")
     private String partOwnershipIndicator;




    /**
     * 对称件
     */
     @ApiModelProperty("对称件")
     private String symmetricPart;




    /**
     * 数量单位
     */
     @ApiModelProperty("数量单位")
     private String unit;
}
