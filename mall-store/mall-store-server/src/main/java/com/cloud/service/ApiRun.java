package com.cloud.service;


import com.cloud.service.ser.DemoDatabaseAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;


/**
 * @author hupeng
 * @date 2019/10/1 9:20:19
 */
@ComponentScan({"com.cloud"})
@SpringBootApplication
public class ApiRun {

    public static void main(String[] args) {
        SpringApplication.run(ApiRun.class, args);
    }
}
