package net.zu.parser.rule.parse;

import net.zu.parser.Rule;
import net.zu.parser.rule.TextSource;
import net.zu.parser.rule.lex.Charset;
import net.zu.parser.state.State;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RangeTest {
    public static final State<TextSource> A7 = TextSource.make("aaaaaaa");

    private Rule<TextSource> a;

    @Before
    public void setUp() throws Exception {
        a = new Charset('a');
    }


    @Test
    public void testSolidTimes() throws Exception {
        Range<TextSource> range = new Range<>(a, 0, 7);

        assertThat(range.match(A7).get().pos(), is(7));
    }

}