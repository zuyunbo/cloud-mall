package com.parserc.state;

import java.util.function.Function;
import java.util.function.Predicate;

public class DefaultState<T> implements State<T> {

    private final T state;

    private final Function<T, T> next;

    private final Predicate<T> tPredicate;


    @Override
    public T get() {
        return state;
    }

    @Override
    public State<T> next() {
        return new DefaultState<>(next.apply(state), next, tPredicate);
    }


    public DefaultState(T state, Function<T, T> next, Predicate<T> tPredicate) {
        this.state = state;
        this.tPredicate = tPredicate;
        this.next = next;
    }

    @Override
    public boolean terminated() {
        return tPredicate.test(state);
    }
}
