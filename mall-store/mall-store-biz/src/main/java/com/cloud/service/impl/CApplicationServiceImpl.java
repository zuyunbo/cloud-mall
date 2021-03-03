package com.cloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.cloud.param.CApplicationParam;
import com.cloud.entity.CApplication;
import com.cloud.mapper.CApplicationMapper;
import com.cloud.service.CApplicationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.stereotype.Service;



import java.util.Map;

/**
 * ${comments}
 *
 * @author 2u c1111
 * @since 1.0 2021-03-02
 */
@Service
public class CApplicationServiceImpl implements CApplicationService {


    @Autowired
    CApplicationMapper cApplicationMapper;

    @Override
    public int save(CApplication entity) {
        return cApplicationMapper.insert(entity);
    }

    @Override
    public int update(CApplication entity) {
        if (entity.getId() == null || entity.getId() == 0L) {
            // 自己定义的异常方法
        }

        return cApplicationMapper.updateById(entity);
    }

    @Override
    public int remove(Long id) {
        if (id == null || id == 0L) {
            // 自己定义的异常方法
        }
        return cApplicationMapper.deleteById(id);
    }

    @Override
    public CApplication getById(Long id) {
        if (id == null || id == 0L) {
            // 自己定义的异常方法
        }

        return cApplicationMapper.selectById(id);
    }

    @Override
    public PageInfo<CApplication> pageQuery(CApplicationParam queryParam) {
        return PageHelper.startPage(queryParam.getPn(), queryParam.getPs())
                .doSelectPageInfo(() -> cApplicationMapper.listQuery(queryParam));
    }


}
