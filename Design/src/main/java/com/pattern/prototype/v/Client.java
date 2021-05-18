package com.pattern.prototype.v;

public class Client {

    private Prototype prototype;

    public Client(Prototype prototype) {
        this.prototype = prototype;
    }

    public Prototype startClone(Prototype c){
       return c.clone();
    }
}
