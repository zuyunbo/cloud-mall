package com.rule;

import com.pattern.co.CharSet;
import com.pattern.co.Exception.MatchException;
import com.pattern.co.Rule;
import com.pattern.co.source.TextSource;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @Author zuyunbo
 * @Date 2021/5/25  4:05 下午
 **/

public class CharsetTest {

    private Rule<TextSource> charset;

    @Test
    public void testCharsetConstructor() throws MatchException {
        charset = new CharSet('a');
        assertEquals(charset.match(TextSource.make("a")).get().pos(), 1);


    }

}
