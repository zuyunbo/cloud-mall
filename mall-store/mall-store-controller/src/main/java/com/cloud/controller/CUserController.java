package com.cloud.controller;

import com.cloud.entity.CUser;
import com.cloud.param.CUserParam;
import com.cloud.service.CUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;



/**
 * ${comments}
 *
 * @author 2u c1111
 * @since 1.0 2021-03-02
 */
@RestController
@RequestMapping("/api/cUser")
@Api(tags="CUser")
public class CUserController {
    @Autowired
    private CUserService cUserService;


}
