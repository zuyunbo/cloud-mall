package net.zu.parser.rule.parse;

import net.zu.parser.Rule;
import net.zu.parser.rule.TextSource;
import net.zu.parser.rule.lex.Charset;
import net.zu.parser.state.State;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharsetTest {

    private Rule<TextSource> charset;


    @Test
    public void testCharsetConstructor() throws Exception{
        Charset charset = new Charset('a');
        State<TextSource> a = charset.match(TextSource.make("a"));
        System.out.println(a.get());
        assertEquals(charset.match(TextSource.make("a")).get().pos(), 1);
    }


}