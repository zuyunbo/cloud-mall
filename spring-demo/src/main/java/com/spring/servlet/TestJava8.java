package com.spring.servlet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author zuyunbo
 * @Date 2021/6/3  5:34 下午
 **/
public class TestJava8 {

    public static void main(String[] args) {
        Integer[] dd = { 1, 2, 3 };
        Stream<Integer> stream = Arrays.stream(dd);
        stream.map(str -> Integer.toString(str)).forEach(str -> {
            System.out.println(str);// 1 ,2 ,3
            System.out.println(str.getClass());// class java.lang.String
        });

        List<Emp> list = Arrays.asList(new Emp("a"), new Emp("b"), new Emp("c"));
        list.stream().map(Emp::getName).forEach(System.out::println);

    }

    public static class Emp {
        private String name;

        public Emp() {
            super();
        }

        public Emp(String name) {
            super();
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }


}
