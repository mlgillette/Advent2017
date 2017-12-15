package advent;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Day15Test {

    @Test
    public void case1() {
        assertThat(Day15.prob1("65", "8921"), is(588));
    }

    @Test
    public void case1Sub() {
        assertThat(Day15.prob1("65", "8921", 5), is(1));

    }

    @Test
    public void case2() {
        assertThat(Day15.prob2("65", "8921"), is(309));
    }
}