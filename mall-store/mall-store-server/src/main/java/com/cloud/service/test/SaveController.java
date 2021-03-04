package com.cloud.service.test;

import cn.hutool.core.bean.BeanUtil;
import com.cloud.cloudcore.base.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.ParameterizedType;

/**
 * @Author zuyunbo
 * @Date 2021/3/3  4:51 下午
 **/
public interface SaveController<Entity, SaveDto> extends BaseController<Entity> {



    @ApiOperation(value = "新增")
    @PostMapping("/save")
    default R<Entity> save(@RequestBody @Validated SaveDto saveDto) {
        R<Entity> result = handlerSave(saveDto);
        if (result.getDefExec()) {
            Entity model = BeanUtil.toBean(saveDto, getEntityClass());
            getBaseService().save(model);
            result.setData(model);
        }
        return result;
    }

    /**
     * 自定义新增
     *
     * @param model 保存对象
     * @return 返回SUCCESS_RESPONSE, 调用默认更新, 返回其他不调用默认更新
     */
    default R<Entity> handlerSave(SaveDto model) {
        return R.successDef();
    }



}
