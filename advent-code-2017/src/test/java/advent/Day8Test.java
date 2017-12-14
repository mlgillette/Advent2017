package advent;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Day8Test {

    @Test
    public void prob1Case1() {
        String testInput = "b inc 5 if a > 1\n" +
                "a inc 1 if b < 5\n" +
                "c dec -10 if a >= 1\n" +
                "c inc -20 if c == 10";

        assertThat(Day8.prob1(testInput), is(1));
    }


    @Test
    public void prob2Case1() {
        String testInput = "b inc 5 if a > 1\n" +
                "a inc 1 if b < 5\n" +
                "c dec -10 if a >= 1\n" +
                "c inc -20 if c == 10";

        assertThat(Day8.prob2(testInput), is(10));
    }

}