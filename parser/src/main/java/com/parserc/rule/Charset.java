package com.parserc.rule;

import com.parserc.Rule;
import com.parserc.exception.MatchException;
import com.parserc.state.State;

import java.util.HashSet;
import java.util.Set;

public class Charset implements Rule<TextSource> {

    private final Set<Character> charset = new HashSet<>();

    public Charset(char begin, char end) {
        while (begin <= end) {
            charset.add(begin);
            begin++;
        }
    }

    public Charset(char begin, int offset) {
        while (--offset >= 0) {
            charset.add((char) (begin + offset));
        }
    }

    public Charset(char... chars) {
        for (char c : chars) {
            charset.add(c);
        }
    }

    public Charset(CharSequence chars) {
        for (int i = 0; i < chars.length(); i++) {
            charset.add(chars.charAt(i));
        }
    }

    public Charset(char c){
        charset.add(c);
    }


    public State<TextSource> match(State<TextSource> source) throws MatchException{
        if(!source.terminated() && charset.contains(source.get().source().charAt(source.get().pos()))){
            return source.next();
        }
        throw new MatchException(String.format("Char match error: expect %s got %s\n",
                charset, String.valueOf(firstOrNull(source.get().source()))));

    }

    private Character firstOrNull(String source) {
        return source.isEmpty() ? null : source.charAt(0);
    }



}
