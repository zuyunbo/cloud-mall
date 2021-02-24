package com.cloud.mallstoreserver.service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


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
