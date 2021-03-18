package com.cloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.cloud.param.UsersParam;
import com.cloud.entity.Users;
import com.cloud.mapper.UsersMapper;
import com.cloud.service.UsersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.stereotype.Service;



import java.util.Map;

/**
 * ${comments}
 *
 * @author 2u c1111
 * @since 1.0 2021-03-17
 */
@Service
public class UsersServiceImpl implements UsersService {


    @Autowired
    UsersMapper usersMapper;

    @Override
    public int save(Users entity) {
        return usersMapper.insert(entity);
    }

    @Override
    public int update(Users entity) {
        if (entity.getId() == null || entity.getId() == 0L) {
            // 自己定义的异常方法
        }

        return usersMapper.updateById(entity);
    }

    @Override
    public int remove(Long id) {
        if (id == null || id == 0L) {
            // 自己定义的异常方法
        }
        return usersMapper.deleteById(id);
    }

    @Override
    public Users getById(Long id) {
        if (id == null || id == 0L) {
            // 自己定义的异常方法
        }

        return usersMapper.selectById(id);
    }

    @Override
    public PageInfo<Users> pageQuery(UsersParam queryParam) {
        return PageHelper.startPage(queryParam.getPn(), queryParam.getPs())
                .doSelectPageInfo(() -> usersMapper.listQuery(queryParam));
    }


}
