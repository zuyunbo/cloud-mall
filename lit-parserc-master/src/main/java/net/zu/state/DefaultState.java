package net.zu.state;

import java.util.UUID;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Author zuyunbo
 * @Date 2021/4/20  1:55 下午
 **/
public class DefaultState<T> implements State<T>{


    private final T state;

    private final Function<T,T> next;

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
        return new DefaultState<>(next.apply(state),next,terminated);
    }

    @Override
    public State<T> next(int n) {
        // 当前节点
        State<T> next = this;
        for (int i = 0; i < n; i++) {
            // 下一节点
            next = this.next();
            if (next.terminated())
                return null;
        }
        return next;
    }

    @Override
    public boolean terminated() {
        return terminated.test(this.state);
    }

    public static void main(String[] args) {
        int c = 10;
        for(int i = 0, j = 3;i<=j;){

            int tmp = i*i+j*j;
            if(tmp<c){
                i++;
            }else if(tmp>c){
                j--;
            }else{
                System.out.println("111");
            }
        }



    }
}
