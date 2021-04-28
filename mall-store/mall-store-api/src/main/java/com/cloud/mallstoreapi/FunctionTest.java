package com.cloud.mallstoreapi;

import java.util.function.Function;

/**
 * @Author zuyunbo
 * @Date 2021/4/21  1:58 下午
 **/
public class FunctionTest {

    private Function<String,String> ds = new Function<String,String>(){

        @Override
        public String apply(String s) {
            return new String("apply" + s);
        }
    };

    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();
        System.out.println(functionTest.ds.apply("hello~!"));
    }


}
