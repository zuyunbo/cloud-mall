package net.zu.parser.rule.parse;

import net.zu.parser.Rule;
import net.zu.parser.exception.MatchException;
import net.zu.parser.state.State;

/**
 * @Author zuyunbo
 * @Date 2021/6/16  10:56 上午
 **/
public class Either<T> implements Rule<T> {

    public final Rule<T> left;
    public final Rule<T> right;


    public Either(Rule<T> left, Rule<T> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public State<T> match(State<T> state) throws MatchException {
        try{
            return left.match(state);
        } catch (MatchException a){
            return right.match(state);
        }
    }
}
