package net.zu.parser.rule;

import net.zu.parser.state.DefaultState;
import net.zu.parser.state.State;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Author zuyunbo
 * @Date 2021/6/15  3:02 下午
 **/
public class TextSource {

    private final int pos;

    private final String source;


    public TextSource(int pos, String source) {
        this.pos = pos;
        this.source = source;
    }

    public static final Function<TextSource,TextSource> NEXT = m -> new TextSource(m.pos+1,m.source);
    public static final Predicate<TextSource> TERMINATED = matcher -> matcher.pos >= matcher.source.length();

    public static State<TextSource> make(String source){
        return new DefaultState<>(new TextSource(0,source),NEXT,TERMINATED);
    }

    public int pos(){
        return pos;
    }

    public String source(){
        return source;
    }

}
