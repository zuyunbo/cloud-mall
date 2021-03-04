package com.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Author zuyunbo
 * @Date 2021/3/4  10:02 上午
 **/
@SuppressWarnings("ALL")
public interface SuperService<T> extends IService<T> {

    Class<T> getEntityClass();

}
