package com.pattern.co.state;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Author zuyunbo
 * @Date 2021/5/25  2:40 下午
 **/
public class DefaultState<T> implements State<T> {

    private final T state;

    private final Function<T, T> next;

    private final Predicate<T> terminated;


    public DefaultState(T state, Function<T, T> next, Predicate<T> terminated) {
        this.state = state;
        this.next = next;
        this.terminated = terminated;
    }

    @Override
    public T get() {
        return state;
    }

    @Override
    public State<T> next() {
        return new DefaultState<>(next.apply(state), next, terminated);
    }

    @Override
    public State<T> next(int n) {
        State<T> next = this;
        for (int i = 0; i < n; i++) {
            next = this.next();
            if(next.terminated())
                return null;
        }

        return next;
    }

    @Override
    public boolean terminated() {
        return terminated.test(this.state);
    }
}
