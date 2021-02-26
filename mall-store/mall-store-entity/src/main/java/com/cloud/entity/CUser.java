package com.cloud.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 *
 * @author 2u c1111
 * @since 1.0 2021-02-26
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Builder
@Api(description = "c_user")
public class CUser {
	private static final long serialVersionUID = 1L;


	private Long id ;
    /**
     * 创建时间
     */
     @ApiModelProperty("创建时间")
     private String createTime;
    /**
     * 创建人
     */
     @ApiModelProperty("创建人")
     private Long createdBy;
    /**
     * 驱动
     */
     @ApiModelProperty("驱动")
     private String driverClassName;
    /**
     * 名称
     */
     @ApiModelProperty("名称")
     private String name;
    /**
     * 密码
     */
     @ApiModelProperty("密码")
     private String password;
    /**
     * 修改时间
     */
     @ApiModelProperty("修改时间")
     private String updateTime;
    /**
     * 修改人
     */
     @ApiModelProperty("修改人")
     private Long updatedBy;
    /**
     * 链接
     */
     @ApiModelProperty("链接")
     private String url;
    /**
     * 账号
     */
     @ApiModelProperty("账号")
     private String username;
}
