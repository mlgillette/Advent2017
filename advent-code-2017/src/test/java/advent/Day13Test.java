package advent;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Day13Test {
    @Test
    public void case1() {
        String input = "0: 3\n" +
                "1: 2\n" +
                "4: 4\n" +
                "6: 4";
        assertThat(Day13.prob1(input), is(24));
    }

    @Test
    public void case2() {
        String input = "0: 3\n" +
                "1: 2\n" +
                "4: 4\n" +
                "6: 4";
        assertThat(Day13.prob2(input), is(10));
    }
}