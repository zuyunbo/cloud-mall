package com.cloud.service.aojo;

import java.util.Map;

/**
 * @Author zuyunbo
 * @Date 2021/3/9  10:18 上午
 **/
public interface CommonPropertyService {

    Map<String, Object> getPartAssemblyMap();

    Map<String, Object> getPartMasterMap();

    Map<String, Object> getPartVersionMap();

    Map<String, Object> getCommonMap();

    <T> void set(T c, String fun, Object value) ;


}
