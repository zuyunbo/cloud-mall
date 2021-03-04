package com.cloud.service.test;

import com.cloud.service.SuperService;

/**
 * @Author zuyunbo
 * @Date 2021/3/3  5:27 下午
 **/
public abstract class SuperController<S extends SuperService<Entity>,Entity ,SaveDTO> extends SuperSimpleController<S ,Entity> implements  SaveController<Entity, SaveDTO>{
}
