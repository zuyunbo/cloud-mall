package com.pattern.co.source;

import com.pattern.co.state.DefaultState;
import com.pattern.co.state.State;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Author zuyunbo
 * @Date 2021/5/25  3:22 下午
 **/
public class TextSource {

    public static final Function<TextSource,TextSource> NEXT = (TextSource m) -> new TextSource(m.pos+1,m.source);
    public static final Predicate<TextSource> TERMINATED = matcher -> matcher.pos >= matcher.source().length();



    private final int pos;

    private final String source;


    public static State<TextSource> make(String source) {
        return new DefaultState<>(new TextSource(0, source), NEXT, TERMINATED);
    }

    public TextSource(int pos, String source) {
        this.pos = pos;
        this.source = source;
    }

    public int pos() {
        return pos;
    }

    public String source() {
        return source;
    }


}
