package com.cloud.cloudgeccoserver.lmada;

import java.util.Objects;
import java.util.function.Function;

public class FunctionTest<In, Out> {

    public Function<In,Out>  function = m -> (Out)new String("apple"+ m);


    public static void main(String[] args) {
        FunctionTest<String, String> functionTest = new FunctionTest();
        System.out.println(functionTest.function.apply("ds"));
    }



}
