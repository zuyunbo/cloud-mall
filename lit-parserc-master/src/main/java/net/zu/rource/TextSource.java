package net.zu.rource;

import net.zu.state.DefaultState;
import net.zu.state.State;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Author zuyunbo
 * @Date 2021/4/20  1:44 下午
 **/
public class TextSource {

    public static final Function<TextSource,TextSource> NEXT = n -> new TextSource(n.pos+1,n.source);

    public static final Predicate<TextSource> TERMINATED = matcher -> matcher.pos >= matcher.source.length();

    // 节点数
    private final int pos;
    // 资源
    private final String source;

    public TextSource(int pos, String source) {
        this.pos = pos;
        this.source = source;
    }

    public static State<TextSource> make(String source) {
        return new DefaultState<>(new TextSource(0, source), NEXT, TERMINATED);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextSource matcher = (TextSource) o;

        if (pos != matcher.pos) return false;
        return !(source != null ? !source.equals(matcher.source) : matcher.source != null);

    }


    @Override
    public int hashCode() {
        int result = pos;
        result = 31 * result + (source != null ? source.hashCode() : 0);
        return result;
    }



}
