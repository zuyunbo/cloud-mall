package com.cloud.controller;

import com.cloud.entity.PartVersion;
import com.cloud.param.CApplicationParam;
import com.cloud.param.PartVersionParam;
import com.cloud.service.PartVersionService;
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

import java.util.ArrayList;
import java.util.List;


/**
 * ${comments}
 *
 * @author 2u c1111
 * @since 1.0 2021-03-05
 */
@RestController
@RequestMapping("/api/partVersion")
@Api(tags="PartVersion")
public class PartVersionController {
    @Autowired
    private PartVersionService partVersionService;

    @GetMapping("page")
    @ApiOperation("分页")
    public Object page(PartVersionParam queryParam){

        return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "查询成功", null);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("删除")
    public Object remove(@PathVariable long id) {
        int result = partVersionService.remove(id);

        if (result > 0) {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "删除成功");
        } else {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.FAILED, "删除失败");
        }
    }


    @PostMapping(value = "/save")
    @ApiOperation("保存")
    public Object save(@RequestBody PartVersion entity) {
        int result = partVersionService.save(entity);

        if (result > 0) {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "保存成功", entity.getId());
        } else {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.FAILED, "保存失败", result);
        }
    }

    @PutMapping(value = "/update")
    @ApiOperation("修改")
    public Object update(@RequestBody PartVersion entity) {
        int result = partVersionService.update(entity);

        if (result > 0) {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "修改成功", entity.getId());
        } else {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.FAILED, "修改失败");
        }
    }


    @GetMapping(value = "/{id}/detail")
    @ApiOperation("详情")
    public Object detail(@PathVariable long id) {
        PartVersion entity = partVersionService.getById(id);
        return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "查询成功", entity);
    }


}
