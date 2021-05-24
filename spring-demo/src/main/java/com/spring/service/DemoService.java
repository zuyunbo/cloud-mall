package com.spring.service;

import com.spring.annotations.GService;

@GService
public class DemoService implements IDemoService {
    @Override
    public String get(String name) {
        return "my name is " + name;
    }
}
