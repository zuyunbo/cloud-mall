package net.zu.parser.rule.parse;

import net.zu.parser.rule.TextSource;
import net.zu.parser.rule.lex.Charset;
import org.junit.Test;

import static org.junit.Assert.*;


public class MaybeTest {

    @Test
    public void testOptionalMatches() throws Exception {
        Maybe<TextSource> maybe = new Maybe<>(new Charset('a', 'z'));
        assertEquals(maybe.match(TextSource.make("abc")).get().pos(), 1);
        assertEquals(maybe.match(TextSource.make("---")).get().pos(), 0);
    }

}