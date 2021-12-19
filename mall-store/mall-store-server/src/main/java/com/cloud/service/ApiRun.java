package com.cloud.service;


import com.cloud.service.controller.SfgController;
import com.cloud.service.syn.Parts;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author hupeng
 * @date 2019/10/1 9:20:19
 */
@ComponentScan({"com.cloud"})
@SpringBootApplication
public class ApiRun {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ApiRun.class, args);
        SfgController bean = run.getBean(SfgController.class);
        bean.sss();
    }
}
