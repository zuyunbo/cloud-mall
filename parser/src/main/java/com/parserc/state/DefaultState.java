package com.parserc.state;

import java.util.function.Predicate;

public class DefaultState<T> implements State<T> {

    private final T state;

    private final Predicate<T> tPredicate;


    @Override
    public T get() {
        return state;
    }

    public DefaultState(T state, Predicate<T> tPredicate) {
        this.state = state;
        this.tPredicate = tPredicate;
    }

    @Override
    public boolean terminated() {
        return tPredicate.test(state);
    }
}
