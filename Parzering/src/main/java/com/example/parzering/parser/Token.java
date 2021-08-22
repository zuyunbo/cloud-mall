package com.example.parzering.parser;

/**
 * @Author zuyunbo
 * @Date 2021/8/21  4:52 下午
 **/
public class Token {

    public final TokenEnum tokenEnum;

    public final Object value;


    public Token(TokenEnum tokenEnum, Object value) {
        this.tokenEnum = tokenEnum;
        this.value = value;
    }
}
