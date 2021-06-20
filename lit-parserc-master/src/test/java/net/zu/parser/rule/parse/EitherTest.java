package net.zu.parser.rule.parse;


import net.zu.parser.Rule;
import net.zu.parser.rule.TextSource;
import net.zu.parser.rule.lex.Charset;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class EitherTest {
    private Rule<TextSource> rule;


    @Test
    public void testEitherMatches() throws Exception {
        rule = new Either<>(new Charset('a'), new Charset('b'));
        assertEquals(rule.match(TextSource.make("abc")).get().pos(), 1);
    }

}