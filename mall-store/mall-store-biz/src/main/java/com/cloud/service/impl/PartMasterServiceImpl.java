package com.cloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.cloud.param.PartMasterParam;
import com.cloud.entity.PartMaster;
import com.cloud.mapper.PartMasterMapper;
import com.cloud.service.PartMasterService;
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
public class PartMasterServiceImpl implements PartMasterService {


    @Autowired
    PartMasterMapper partMasterMapper;

    @Override
    public int save(PartMaster entity) {
        return partMasterMapper.insert(entity);
    }

    @Override
    public int update(PartMaster entity) {
        if (entity.getId() == null || entity.getId() == 0L) {
            // 自己定义的异常方法
        }

        return partMasterMapper.updateById(entity);
    }

    @Override
    public int remove(Long id) {
        if (id == null || id == 0L) {
            // 自己定义的异常方法
        }
        return partMasterMapper.deleteById(id);
    }

    @Override
    public PartMaster getById(Long id) {
        if (id == null || id == 0L) {
            // 自己定义的异常方法
        }

        return partMasterMapper.selectById(id);
    }

    @Override
    public PageInfo<PartMaster> pageQuery(PartMasterParam queryParam) {
        return PageHelper.startPage(queryParam.getPn(), queryParam.getPs())
                .doSelectPageInfo(() -> partMasterMapper.listQuery(queryParam));
    }


}
