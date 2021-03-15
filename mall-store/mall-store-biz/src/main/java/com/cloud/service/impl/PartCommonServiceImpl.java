package com.cloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.cloud.param.PartCommonParam;
import com.cloud.entity.PartCommon;
import com.cloud.mapper.PartCommonMapper;
import com.cloud.service.PartCommonService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.stereotype.Service;



import java.util.Map;

/**
 * ${comments}
 *
 * @author 2u c1111
 * @since 1.0 2021-03-12
 */
@Service
public class PartCommonServiceImpl implements PartCommonService {


    @Autowired
    PartCommonMapper partCommonMapper;

    @Override
    public int save(PartCommon entity) {
        return partCommonMapper.saveByEntity(entity);
    }

    @Override
    public int update(PartCommon entity) {
        if (entity.getId() == null || entity.getId() == 0L) {
            // 自己定义的异常方法
        }

        return partCommonMapper.updateById(entity);
    }

    @Override
    public int remove(Long id) {
        if (id == null || id == 0L) {
            // 自己定义的异常方法
        }
        return partCommonMapper.deleteById(id);
    }

    @Override
    public PartCommon getById(Long id) {
        if (id == null || id == 0L) {
            // 自己定义的异常方法
        }

        return partCommonMapper.selectById(id);
    }

    @Override
    public PageInfo<PartCommon> pageQuery(PartCommonParam queryParam) {
        return PageHelper.startPage(queryParam.getPn(), queryParam.getPs())
                .doSelectPageInfo(() -> partCommonMapper.listQuery(queryParam));
    }


}
