package net.zu.parser.state;

/**
 * 状态
 * @param <T>
 */
public interface State<T> {
    T get();

    State<T> next();

    State<T> next(int n);

    boolean terminated();
}
