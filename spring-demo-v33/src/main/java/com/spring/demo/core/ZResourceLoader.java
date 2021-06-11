package com.spring.demo.core;

import org.springframework.core.io.Resource;

/**
 * @Author zuyunbo
 * @Date 2021/6/11  2:03 下午
 **/
public interface ZResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String var1);


}
