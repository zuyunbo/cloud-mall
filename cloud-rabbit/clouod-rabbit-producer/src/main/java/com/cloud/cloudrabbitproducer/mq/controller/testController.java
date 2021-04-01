package com.cloud.cloudrabbitproducer.mq.controller;


import com.cloud.cloudrabbitproducer.mq.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/rabbitmq")
public class testController {

    @Autowired
    Producer producer;

    @GetMapping("/code1")
    public String generator1() {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("attr1", "12345");
        properties.put("attr2", "abcde");
        producer.sendMsg("hello rabbitmq!", properties);

        return "111";
    }

}