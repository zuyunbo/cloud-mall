package com.cloud.cloudgeccoserver.lmada;

import java.util.function.Function;

public class FuncationTest <IN,OUT>{

    private Function<IN,OUT> processor = new Function<IN, OUT>() {
        @Override
        public OUT apply(IN in) {
            return (OUT)new String("Aapply: " + in);
        }
    };

    public static void main(String[] args) {
        FuncationTest<String, String> functionTest = new FuncationTest();
        System.out.println(functionTest.processor.apply("hello~!"));
    }



}
