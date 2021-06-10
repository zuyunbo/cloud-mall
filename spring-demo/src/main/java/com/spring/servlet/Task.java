package com.spring.servlet;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author zuyunbo
 * @Date 2021/6/3  5:19 下午
 **/

@Data
public class Task {

    private String name;

    private String code;

    private String demo;

    private String age;

    private String yang;

    public Task(String name, String code, String demo, String age, String yang) {
        this.name = name;
        this.code = code;
        this.demo = demo;
        this.age = age;
        this.yang = yang;
    }

    public static Map<String, String> getTask(Task task, String type) {
        Map<String, String> map = new HashMap<>();
        map.put("name", task.getName());
        map.put("code", task.getCode());
        map.put("demo", task.getDemo());
        map.put("age", task.getAge());

        if ("2".equals(type)) {
            map.put("yang", task.getAge());
        }
        return map;


    }

    private Boolean equalsString(String var, String var1) {
        return var.equals(var1);
    }

    public static void main(String[] args) {

        List<Task> list = new ArrayList<>();
        list.add(new Task("1","1","1","1","1"));
        list.add(new Task("2","2","2","2","2"));
        list.add(new Task("3","3","3","3","3"));
        list.add(new Task("4","4","4","4","4"));
        list.add(new Task("5","5","5","5","5"));
        list.add(new Task("6","6","6","6","6"));

        List<Map<String, String>> collect = list.stream().map(task -> Task.getTask(task, "2")).collect(Collectors.toList());
        System.out.println(collect);

    }




}
