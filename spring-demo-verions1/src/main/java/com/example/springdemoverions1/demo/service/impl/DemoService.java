package com.example.springdemoverions1.demo.service.impl;


import com.example.springdemoverions1.annotation.GPService;
import com.example.springdemoverions1.demo.service.IDemoService;

/**
 * 核心业务逻辑
 */
@GPService
public class DemoService implements IDemoService {

	public String get(String name) {
		return "My name is " + name;
	}

}
