package net.zu.rule.parse;

import net.zu.exception.MatchException;
import net.zu.node.Node;
import net.zu.rule.CompoundRule;
import net.zu.rule.Rule;
import net.zu.state.State;

/**
 * @Author zuyunbo
 * @Date 2021/4/25  2:48 下午
 **/
public class Either<T> implements CompoundRule<T> {

    public final Rule<T> left;

    public final Rule<T> right;

    public Either(Rule<T> left, Rule<T> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public State<T> match(State<T> source) throws MatchException {
        try {
            return left.match(source);
        } catch (MatchException e) {
            return right.match(source);
        }
    }

    @Override
    public Node parse(State<T> source) throws MatchException {
        try {
            return left.parse(source);
        } catch (MatchException e) {
            return right.parse(source);
        }    }
}
