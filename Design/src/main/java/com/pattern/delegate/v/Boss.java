package com.pattern.delegate.v;

public class Boss {


    public void command(String command,Leader leader){
        leader.doing(command);
    }

}
