package net.zu.rule;

import net.zu.exception.MatchException;
import net.zu.node.Node;
import net.zu.rule.parse.Either;
import net.zu.state.State;

/**
 *
 * The rule implement basic matchRule
 * Match the most basic rules
 * @Author zuyunbo
 * @Date 2021/4/22  10:24 上午
 **/
public interface Rule<T> {
   /**
    * match data
    * @param source
    * @return State
    * @throws MatchException
    */
   State<T> match(State<T> source) throws MatchException;

   /**
    * parse data
    * @param source
    * @return Node data instance
    * @throws MatchException
    */
   Node parse(State<T> source) throws MatchException;

   /**
    * or date rule
    * @param rule
    * @return defalut Rule
    */
   default Rule<T> or(Rule<T> rule) {
      return new Either<>(this, rule);
   }







}
