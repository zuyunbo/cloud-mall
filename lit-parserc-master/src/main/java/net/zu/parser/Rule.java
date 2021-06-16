package net.zu.parser;

import net.zu.parser.exception.MatchException;
import net.zu.parser.state.State;

/**
 * @Author zuyunbo
 * @Date 2021/6/15  2:11 下午
 **/
public interface Rule<T> {

   State<T>  match(State<T> state) throws MatchException;
}
