package advent;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Day19Test {

    private String input =
            "     |          \n" +
            "     |  +--+    \n" +
            "     A  |  C    \n" +
            " F---|----E|--+ \n" +
            "     |  |  |  D \n" +
            "     +B-+  +--+ \n" +
            "\n";

    @Test
    public void case1() {
        assertThat(Day19.prob1(input), is("ABCDEF"));
    }

    @Test
    public void case2() {
        assertThat(Day19.prob2(input), is(38));
    }

}