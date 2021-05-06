package com.zu.design.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zuyunbo
 * @Date 2021/5/6  4:17 下午
 **/
public class Leder implements IEmployee{

    private Map<String,IEmployee> stringIEmployeeMap = new HashMap<>();

    public Leder() {
        stringIEmployeeMap.put("加密",new EmployeeA());
        stringIEmployeeMap.put("登陆",new EmployeeB());

    }

    @Override
    public void doing(String command) {
        stringIEmployeeMap.get(command).doing(command);
    }
}
