package com.cloud.mallstoreserver.service.ser;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.cloud.mallstoreserver.service.datasource.defaults.BaseMasterDatabaseConfiguration;
import com.cloud.mallstoreserver.service.properties.DatabaseProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zuyunbo
 * @Date 2021/2/24  2:24 下午
 **/
@Slf4j
@Configuration
@MapperScan(
        basePackages = {"com.cloud.mallstoreserver"},
        annotationClass = Repository.class,
        sqlSessionFactoryRef = DemoDatabaseAutoConfiguration.DATABASE_PREFIX + "SqlSessionFactory")
@ConditionalOnExpression("!'DATASOURCE'.equals('${lamp.database.multiTenantType}')")
public class DemoDatabaseAutoConfiguration extends BaseMasterDatabaseConfiguration {
    public DemoDatabaseAutoConfiguration(MybatisPlusProperties properties,
                                         DatabaseProperties databaseProperties,
                                         ObjectProvider<Interceptor[]> interceptorsProvider,
                                         ObjectProvider<TypeHandler[]> typeHandlersProvider,
                                         ObjectProvider<LanguageDriver[]> languageDriversProvider,
                                         ResourceLoader resourceLoader,
                                         ObjectProvider<DatabaseIdProvider> databaseIdProvider,
                                         ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider,
                                         ObjectProvider<List<MybatisPlusPropertiesCustomizer>> mybatisPlusPropertiesCustomizerProvider,
                                         ApplicationContext applicationContext) {
        super(properties, databaseProperties, interceptorsProvider, typeHandlersProvider,
                languageDriversProvider, resourceLoader, databaseIdProvider,
                configurationCustomizersProvider, mybatisPlusPropertiesCustomizerProvider, applicationContext);
        log.debug("检测到 lamp.database.multiTenantType!=DATASOURCE，启用了 AuthorityDatabaseAutoConfiguration");
    }

}
