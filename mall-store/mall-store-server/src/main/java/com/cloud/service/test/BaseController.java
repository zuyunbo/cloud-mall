package com.cloud.service.test;

import com.cloud.service.SuperService;

/**
 * @Author zuyunbo
 * @Date 2021/3/3  4:59 下午
 **/
public interface BaseController<Entity> {

    Class<Entity> getEntityClass();


    SuperService<Entity> getBaseService();

}
