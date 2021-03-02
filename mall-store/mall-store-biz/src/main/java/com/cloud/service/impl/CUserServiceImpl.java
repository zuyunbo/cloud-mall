package com.cloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.cloud.param.CUserParam;
import com.cloud.entity.CUser;
import com.cloud.mapper.CUserMapper;
import com.cloud.service.CUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;




/**
 * ${comments}
 *
 * @author 2u c1111
 * @since 1.0 2021-02-28
 */
@Service
public class CUserServiceImpl implements CUserService {


    @Autowired
    CUserMapper cUserMapper;

    @Override
    public int save(CUser entity) {
        return cUserMapper.insert(entity);
    }

    @Override
    public int update(CUser entity) {
        if (entity.getId() == null || entity.getId() == 0L) {
            // 自己定义的异常方法
        }

        return cUserMapper.updateById(entity);
    }

    @Override
    public int remove(Long id) {
        if (id == null || id == 0L) {
            // 自己定义的异常方法
        }
        return cUserMapper.deleteById(id);
    }

    @Override
    public CUser getById(Long id) {
        if (id == null || id == 0L) {
            // 自己定义的异常方法
        }

        return cUserMapper.selectById(id);
    }

    @Override
    public PageInfo<CUser> pageQuery(CUserParam queryParam) {
        return PageHelper.startPage(queryParam.getPn(), queryParam.getPs())
                .doSelectPageInfo(() -> cUserMapper.listQuery(queryParam));
    }


}
