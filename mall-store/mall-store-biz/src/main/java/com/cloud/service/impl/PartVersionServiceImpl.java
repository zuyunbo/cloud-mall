package com.cloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.cloud.param.PartVersionParam;
import com.cloud.entity.PartVersion;
import com.cloud.mapper.PartVersionMapper;
import com.cloud.service.PartVersionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.stereotype.Service;



import java.util.Map;

/**
 * ${comments}
 *
 * @author 2u c1111
 * @since 1.0 2021-03-05
 */
@Service
public class PartVersionServiceImpl implements PartVersionService {


    @Autowired
    PartVersionMapper partVersionMapper;

    @Override
    public int save(PartVersion entity) {
        return partVersionMapper.insert(entity);
    }

    @Override
    public int update(PartVersion entity) {
        if (entity.getId() == null || entity.getId() == 0L) {
            // 自己定义的异常方法
        }

        return partVersionMapper.updateById(entity);
    }

    @Override
    public int remove(Long id) {
        if (id == null || id == 0L) {
            // 自己定义的异常方法
        }
        return partVersionMapper.deleteById(id);
    }

    @Override
    public PartVersion getById(Long id) {
        if (id == null || id == 0L) {
            // 自己定义的异常方法
        }

        return partVersionMapper.selectById(id);
    }

    @Override
    public PageInfo<PartVersion> pageQuery(PartVersionParam queryParam) {
        return PageHelper.startPage(queryParam.getPn(), queryParam.getPs())
                .doSelectPageInfo(() -> partVersionMapper.listQuery(queryParam));
    }


}
