package com.parserc.state;

public interface State<T> {

     public T get();

     boolean terminated();

}



