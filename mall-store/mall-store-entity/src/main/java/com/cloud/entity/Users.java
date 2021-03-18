package com.cloud.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


/**
 * @author 2u c1111
 * @since 1.0 2021-03-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@Api(description = "users")
public class Users {
    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty("")
    private String username;

    @ApiModelProperty("")
    private String password;

    @ApiModelProperty("")
    private String nickname;

    @ApiModelProperty("")
    private String realname;

    @ApiModelProperty("")
    private String face;

    @ApiModelProperty("")
    private String mobile;

    @ApiModelProperty("")
    private String email;

    @ApiModelProperty("")
    private Integer sex;

    @ApiModelProperty("")
    private Date birthday;

    @ApiModelProperty("")
    private Date createdTime;

    @ApiModelProperty("")
    private Date updateTime;
}
