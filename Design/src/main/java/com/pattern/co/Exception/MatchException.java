package com.pattern.co.Exception;

/**
 * @Author zuyunbo
 * @Date 2021/5/25  3:43 下午
 **/
public class MatchException extends Exception{

    public MatchException(String message){
        super(message);
    }

    public MatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
