package com.cloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.cloud.param.PartAssemblyParam;
import com.cloud.entity.PartAssembly;
import com.cloud.mapper.PartAssemblyMapper;
import com.cloud.service.PartAssemblyService;
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
public class PartAssemblyServiceImpl implements PartAssemblyService {


    @Autowired
    PartAssemblyMapper partAssemblyMapper;

    @Override
    public int save(PartAssembly entity) {
        return partAssemblyMapper.insert(entity);
    }

    @Override
    public int update(PartAssembly entity) {
        if (entity.getId() == null || entity.getId() == 0L) {
            // 自己定义的异常方法
        }

        return partAssemblyMapper.updateById(entity);
    }

    @Override
    public int remove(Long id) {
        if (id == null || id == 0L) {
            // 自己定义的异常方法
        }
        return partAssemblyMapper.deleteById(id);
    }

    @Override
    public PartAssembly getById(Long id) {
        if (id == null || id == 0L) {
            // 自己定义的异常方法
        }

        return partAssemblyMapper.selectById(id);
    }

    @Override
    public PageInfo<PartAssembly> pageQuery(PartAssemblyParam queryParam) {
        return PageHelper.startPage(queryParam.getPn(), queryParam.getPs())
                .doSelectPageInfo(() -> partAssemblyMapper.listQuery(queryParam));
    }


}
