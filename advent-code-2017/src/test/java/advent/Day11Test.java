package advent;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Day11Test {

    @Test
    public void case1() {
        assertThat(Day11.prob1("ne,ne,ne"), is(3));
        assertThat(Day11.prob1("ne,ne,sw,sw"), is(0));
        assertThat(Day11.prob1("ne,ne,s,s"), is(2));
        assertThat(Day11.prob1("se,sw,se,sw,sw"), is(3));
    }

    @Test
    public void case2() {
        assertThat(Day11.prob2("ne,ne,ne"), is(3));
        assertThat(Day11.prob2("ne,ne,sw,sw"), is(2));
        assertThat(Day11.prob2("ne,ne,s,s"), is(2));
        assertThat(Day11.prob2("se,sw,se,sw,sw"), is(3));
    }
}