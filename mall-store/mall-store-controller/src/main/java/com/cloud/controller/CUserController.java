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

import java.util.HashMap;
import java.util.Map;


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


    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<>();
        map.put("createDateFrom","2021-04-15");
        map.put("publishDateStart","2021-04-15");
        for (String ste : map.keySet()) {
            if ("createDateFrom".equals(ste)) {
                Object createDateFrom = map.get("createDateFrom");
                map.put("createDateFrom", createDateFrom + " 00:00");
            }
            if ("publishDateStart".equals(ste)) {
                Object publishDateStart = map.get("publishDateStart");
                map.put("publishDateStart", publishDateStart + " 23:59");
            }
        }
        System.out.println(map.get("createDateFrom"));
        System.out.println(map.get("publishDateStart"));

    }


}
