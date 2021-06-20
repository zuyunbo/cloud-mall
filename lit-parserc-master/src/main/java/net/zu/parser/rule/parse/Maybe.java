package net.zu.parser.rule.parse;

import net.zu.parser.Rule;
import net.zu.parser.exception.MatchException;
import net.zu.parser.state.State;

/**
 * @Author zuyunbo
 * @Date 2021/6/16  11:25 上午
 **/
public class Maybe<T> implements Rule<T> {


    public final Rule<T> rule;


    public Maybe(Rule<T> rule) {
        this.rule = rule;
    }

    @Override
    public State<T> match(State<T> state) throws MatchException {
       try {
           return rule.match(state);
       } catch (MatchException e){
           return state;
       }
    }
}
