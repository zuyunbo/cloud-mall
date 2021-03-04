package com.cloud.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cloud.cloudcore.base.R;
import com.cloud.mapper.SuperMapper;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;

/**
 * @Author zuyunbo
 * @Date 2021/3/4  10:08 上午
 **/
public class SuperServiceImpl<M extends SuperMapper<T>, T> extends ServiceImpl<M, T> implements SuperService<T> {

    private Class<T> entityClass = null;

    /**
     * 返回mapper
     * @return
     */
    public SuperMapper getSuperMapper() {
        if (baseMapper != null) {
            return baseMapper;
        }
        return null;
    }

    @Override
    public Class<T> getEntityClass() {
        if (entityClass == null) {
            this.entityClass = (Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        }
        return this.entityClass;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(T model) {
        R<Boolean> result = handlerSave(model);
        if (result.getDefExec()) {
            return super.save(model);
        }
        return result.getData();
    }

    /**
     * 处理新增相关处理
     *
     * @param model 实体
     * @return 是否成功
     */
    protected R<Boolean> handlerSave(T model) {
        return R.successDef();
    }



}
