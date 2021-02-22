package com.cloud.mallstoreserver.service.datasource.defaults;

import cn.hutool.core.util.ArrayUtil;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.p6spy.engine.spy.P6DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Author zuyunbo
 * @Date 2021/2/20  2:05 下午
 **/

@Slf4j
public abstract class BaseMasterDatabaseConfiguration {

    /**
     * 测试环境
     */
    protected static final String[] DEV_PROFILES = new String[]{"dev"};


    /**
     * 每个数据源配置不同即可
     */
    public static final String DATABASE_PREFIX = "master";


    @Value("${spring.profiles.active:dev}")
    protected String profiles;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource druidDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = DATABASE_PREFIX + "DataSource")
    public DataSource dataSource(@Qualifier(DATABASE_PREFIX + "DruidDataSource") DataSource dataSource) {
        if (ArrayUtil.contains(DEV_PROFILES, this.profiles)) {
            return new P6DataSource(dataSource);
        } else {
            return dataSource;
        }
    }

}
