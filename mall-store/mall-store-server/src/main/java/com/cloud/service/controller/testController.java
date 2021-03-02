package com.cloud.service.controller;

import com.cloud.cloudbaseutil.base.controller.GeneratorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zuyunbo
 * @Date 2021/3/2  11:34 上午
 **/
@RestController
@RequestMapping("/test")
public class testController implements GeneratorController {

    @GetMapping("/code1")
    public String generator1(){
          return "111";
    }

}
