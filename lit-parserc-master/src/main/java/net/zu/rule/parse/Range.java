package net.zu.rule.parse;

import net.zu.exception.MatchException;
import net.zu.node.Node;
import net.zu.rule.CompoundRule;
import net.zu.rule.Rule;
import net.zu.state.State;

/**
 * @Author zuyunbo
 * @Date 2021/4/25  3:02 下午
 **/
public class Range<T> implements CompoundRule<T> {

    public final Rule<T> rule;
    public final int begin;
    public final int end;

    public Range(Rule<T> rule, int begin, int end) {
        this.rule = rule;
        this.begin = begin;
        this.end = end;
    }



    @Override
    public State<T> match(State<T> source) throws MatchException {
        // 如果
        if(source.next(Math.min(begin, end)).terminated())
            throw new MatchException(String.format("Range match error: Out of Range[%d,%d]\n",begin,end));
        if(begin == 0){
            return matchFor(end, source);
        } else {
            State<T> matches = matchFor(begin,source);
            int betweenCount = 0;



        }
        return null;
    }

    @Override
    public Node parse(State<T> source) throws MatchException {
        return null;
    }

    private State<T> matchFor(int times, State<T> source) throws MatchException{
        State<T> matches = source;
        for (int i = 0; i < times; i++) {
            matches = rule.match(matches);
        }
        return matches;
    }

}
