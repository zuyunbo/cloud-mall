package com.parserc;


import com.parserc.exception.MatchException;
import com.parserc.rule.Charset;
import com.parserc.rule.TextSource;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CharsetTest {

    private Rule<TextSource> charset;

    @Test
    public void testCharsetConstructor() throws Exception {
        charset = new Charset('a');
        assertEquals(charset.match(TextSource.make("a")).get().pos(), 1);
    }

    @Test
    public void testCharsetRangeConstructor() throws Exception {
        charset = new Charset('a', 'z');
        assertEquals(charset.match(TextSource.make("d")).get().pos(), 1);
    }

    @Test
    public void testCharsetVarargsConstructor() throws Exception {
        charset = new Charset('a', 'b', 'c', 'd', 'e');
        assertEquals(charset.match(TextSource.make("c")).get().pos(), 1);
    }

    @Test(expected = MatchException.class)
    public void testUnexpectedCharset() throws Exception {
        charset = new Charset("abcde1#2");
        charset.match(TextSource.make("0"));
    }

    @Test
    public void testCharsetOffsetConstructor() throws Exception {
        charset = new Charset('a', 3);
        assertEquals(charset.match(TextSource.make("c")).get().pos(), 1);
    }

    @Test(expected = MatchException.class)
    public void testUnexpectedOffsetConstructor() throws Exception {
        charset = new Charset('a', 3);
        assertEquals(charset.match(TextSource.make("z")).get().pos(), 1);

    }
}