package com.cloud.controller;

import com.cloud.entity.Users;
import com.cloud.param.UsersParam;
import com.cloud.service.UsersService;
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
 * @since 1.0 2021-03-17
 */
@RestController
@RequestMapping("/api/users")
@Api(tags="Users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam( value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam( value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam( value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    public Object page(UsersParam queryParam){
        PageInfo pageInfo = usersService.pageQuery(queryParam);

        return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "查询成功", pageInfo);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("删除")
    public Object remove(@PathVariable long id) {
        int result = usersService.remove(id);

        if (result > 0) {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "删除成功");
        } else {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.FAILED, "删除失败");
        }
    }


    @PostMapping(value = "/save")
    @ApiOperation("保存")
    public Object save(@RequestBody Users entity) {
        int result = usersService.save(entity);

        if (result > 0) {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "保存成功", entity.getId());
        } else {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.FAILED, "保存失败", result);
        }
    }

    @PutMapping(value = "/update")
    @ApiOperation("修改")
    public Object update(@RequestBody Users entity) {
        int result = usersService.update(entity);

        if (result > 0) {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "修改成功", entity.getId());
        } else {
            return BaseResponseUtil.constructResponse(BaseResponseUtil.FAILED, "修改失败");
        }
    }


    @GetMapping(value = "/{id}/detail")
    @ApiOperation("详情")
    public Object detail(@PathVariable long id) {
        Users entity = usersService.getById(id);
        return BaseResponseUtil.constructResponse(BaseResponseUtil.SUCCESS, "查询成功", entity);
    }


}
