package com.parserc.state;

public interface State<T> {

     public T get();

     State<T> next();


     boolean terminated();

}



