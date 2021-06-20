package net.zu.parser.rule.lex;

import net.zu.parser.Rule;
import net.zu.parser.exception.MatchException;
import net.zu.parser.rule.TextSource;
import net.zu.parser.state.State;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author zuyunbo
 * @Date 2021/6/15  3:46 下午
 **/
public class Charset implements Rule<TextSource> {

    private final Set<Character> characters = new HashSet<>();

    public Charset(char c) {
        characters.add(c);
    }

    public Charset(char begin, char end) {
        while (begin <= end) {
            characters.add(begin);
            begin++;
        }
    }



    private Character firstOrNull(String source) {
        return source.isEmpty() ? null : source.charAt(0);
    }


    @Override
    public State<TextSource> match(State<TextSource> source) throws MatchException {
        if (!source.terminated() && characters.contains(source.get().source().charAt(source.get().pos()))) {
            return source.next();
        }
        throw new MatchException(String.format("Char match error: expect %s got %s\n",
                characters, String.valueOf(firstOrNull(source.get().source()))));

    }
}
