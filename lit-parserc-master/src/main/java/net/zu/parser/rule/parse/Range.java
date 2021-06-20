package net.zu.parser.rule.parse;

import net.zu.parser.Rule;
import net.zu.parser.exception.MatchException;
import net.zu.parser.exception.RangeMatchException;
import net.zu.parser.state.State;

/**
 * @Author zuyunbo
 * @Date 2021/6/16  1:45 下午
 **/
public class Range<T> implements Rule<T> {

    public final Rule<T> rule;

    public final int begin;

    public final int end;

    public Range(Rule<T> rule, int begin, int end) {
        this.rule = rule;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public State<T> match(State<T> state) throws MatchException {
        if(state.next(Math.min(begin,end)).terminated()){
            throw new MatchException(String.format("Range match error: Out of Range[%d, %d]\n", begin, end));
        }
        if(begin == 0){
            this.matchFor(end,state);
        }else {
            State<T> matches = matchFor(begin, state);
            int betweenCount = 0;
            try {
                while (true) {
                    if (end > begin && betweenCount > end - begin) throw new RangeMatchException();
                    matches = rule.match(matches);
                    betweenCount++;
                }
            } catch (RangeMatchException e) {
                throw new MatchException(String.format("Range match error: Index %d Out of Range[%d, %d]\n",
                        betweenCount, begin, end), e);
            } catch (MatchException ex) {
                return matches;
            }
        }



        return null;
    }

    private State<T> matchFor(int times,State<T> source) throws MatchException {
        State<T> matches = source;
        for (int i = 0; i < times; i++) {
            matches = rule.match(matches);
        }
        return matches;

    }

}
