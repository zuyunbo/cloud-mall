package com.parserc.rule;

public class TextSource {


    private final int pos;


    private final String source;


    public TextSource(int pos, String source) {
        this.pos = pos;
        this.source = source;
    }

    public int pos(){
        return pos;
    }

    public String source(){
        return source;
    }
}
