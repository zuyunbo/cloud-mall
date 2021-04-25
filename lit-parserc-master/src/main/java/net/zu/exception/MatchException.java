package net.zu.exception;

/**
 * @Author zuyunbo
 * @Date 2021/4/22  10:25 上午
 **/
public class MatchException extends Exception {
    public MatchException(String message) {
        super(message);
    }

    public MatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
