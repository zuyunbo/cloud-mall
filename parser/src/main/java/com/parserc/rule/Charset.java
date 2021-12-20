package com.parserc.rule;

import com.parserc.state.State;

import java.util.HashSet;
import java.util.Set;

public class Charset {

    private final Set<Character> charset = new HashSet<>();

    public Charset(char c){
        charset.add(c);
    }


    public State<TextSource> match(State<TextSource> source){
        if(!source.terminated() && charset.contains(source.get().source().charAt(source.get().pos()))){

        }
        return null;


    }



}
