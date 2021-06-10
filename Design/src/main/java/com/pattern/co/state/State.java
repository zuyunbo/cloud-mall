package com.pattern.co.state;

import org.apache.poi.ss.formula.functions.T;

/**
 * @Author zuyunbo
 * @Date 2021/5/25  2:33 下午
 **/
public interface State<T> {

    T get();

    State<T> next();

    State<T> next(int n);

    boolean terminated();


}
