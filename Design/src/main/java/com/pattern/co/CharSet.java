package com.pattern.co;

import com.pattern.co.Exception.MatchException;
import com.pattern.co.source.TextSource;
import com.pattern.co.state.State;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author zuyunbo
 * @Date 2021/5/25  2:19 下午
 **/
public class CharSet implements Rule<TextSource>{

    private final Set<Character> characters = new HashSet<>();


    public CharSet(char c) {
        characters.add(c);
    }

    public CharSet(char... chars) {
        for (char c : chars) {
            characters.add(c);
        }
    }

    public CharSet(CharSequence chars) {
        for (int i = 0; i < chars.length(); i++) {
            characters.add(chars.charAt(i));
        }
    }

    public CharSet(char begin, int offset) {
        while (--offset >= 0) {
            characters.add((char) (begin + offset));
        }
    }

    public State<TextSource> match(State<TextSource> source) throws MatchException {
        if (!source.terminated() && characters.contains(source.get().source().charAt(source.get().pos()))) {
            return source.next();
        }
        throw new MatchException(String.format("Char match error: expect %s got %s\n",
                characters, firstOrNull(source.get().source())));
    }

    private Character firstOrNull(String source) {
        return source.isEmpty() ? null : source.charAt(0);
    }


}
