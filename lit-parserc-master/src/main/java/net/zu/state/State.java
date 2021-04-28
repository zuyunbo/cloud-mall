package net.zu.state;

/**
 * @Author zuyunbo
 * @Date 2021/4/20  1:53 下午
 **/
public interface State<T> {

    T get();

    State<T> next();

    State<T> next(int n);

    boolean terminated();

}
