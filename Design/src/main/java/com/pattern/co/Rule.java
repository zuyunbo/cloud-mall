package com.pattern.co;

import com.pattern.co.Exception.MatchException;
import com.pattern.co.state.State;

/**
 * @Author zuyunbo
 * @Date 2021/5/25  4:07 下午
 **/
public interface Rule<T> {

    State<T> match(State<T> source) throws MatchException;

}
