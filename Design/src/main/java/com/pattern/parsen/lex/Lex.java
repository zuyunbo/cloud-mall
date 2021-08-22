package com.pattern.parsen.lex;

import cn.hutool.core.util.ArrayUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author zuyunbo
 * @Date 2021/7/15  10:08 下午
 **/
public class Lex {

    private static List<String> BRACKET = Arrays.asList("(", ")");

    private static List<String> OPERATE = Arrays.asList("+", "-", "*", "/");

    private static HashMap<String, String> COLLECT = new HashMap<String, String>() {{
        put("*", "chenghao");
        put("+", "jiahao");
        put("-", "jianhao");
        put("/", "chuhao");
        put("(", "zuokuohao");
        put(")", "youkuohao");
    }};

    private String source;

    private int index;


    public Lex(String source) {
        this.source = source;
    }

    private void analysis() {
        while(!EOF()){
            parsean();
        }
    }

    private void parsean() {




    }

    private char corrent(){
        if (!EOF()){
            return source.charAt(index);
        }
        return 'a';
    }


    public boolean EOF() {
        return index > source.length();
    }


}
