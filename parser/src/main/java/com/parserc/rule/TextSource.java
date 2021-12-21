package com.parserc.rule;

import com.parserc.state.DefaultState;
import com.parserc.state.State;

import java.util.function.Function;
import java.util.function.Predicate;

public class TextSource {


    public static final Function<TextSource, TextSource> NEXT = m -> new TextSource(m.pos + 1, m.source());
    public static final Predicate<TextSource> TERMINATED = matcher -> matcher.pos >= matcher.source().length();

    private final int pos;


    private final String source;



    // 装载String
    // State为DefaultState的父类 state<TextSource>源文件
    public static State<TextSource> make(String source) {
        return new DefaultState<>(new TextSource(0, source), NEXT, TERMINATED);
    }

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
