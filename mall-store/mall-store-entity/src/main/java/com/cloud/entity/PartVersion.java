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
@Api(description = "part_version")
public class PartVersion {
	private static final long serialVersionUID = 1L;

    private Long id;





    /**
     * 售后旧件处理
     */
     @ApiModelProperty("售后旧件处理")
     private String afterSalesDisposal;




    /**
     * 零件变更单
     */
     @ApiModelProperty("零件变更单")
     private String changeNumberPartVersion;




    /**
     * 图纸版本
     */
     @ApiModelProperty("图纸版本")
     private String drawingIndex;




    /**
     * 零件版本
     */
     @ApiModelProperty("零件版本")
     private String partChangeIndex;




    /**
     * 零件目标生效时间
     */
     @ApiModelProperty("零件目标生效时间")
     private String partTid;




    /**
     * 生产旧件处理
     */
     @ApiModelProperty("生产旧件处理")
     private String seriesDisposal;
}
