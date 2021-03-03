package com.cloud.service.test;

/**
 * @Author zuyunbo
 * @Date 2021/3/3  5:27 下午
 **/
public abstract class SuperController<Entity ,SaveDTO> extends SuperSimpleController<Entity> implements  SaveController<Entity, SaveDTO>{
}
