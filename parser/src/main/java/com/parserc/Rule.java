package com.parserc;

import com.parserc.exception.MatchException;
import com.parserc.state.State;

public interface Rule<T> {

    State<T> match(State<T> source) throws MatchException;


}
