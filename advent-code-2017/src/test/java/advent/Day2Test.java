package advent;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Day2Test {

    @Test
    public void prob1Case1() {
        assertThat(Day2.manhattanSpiral(1), is(0));
    }

    @Test
    public void prob1Case2() {
        assertThat(Day2.manhattanSpiral(12), is(3));
    }

    @Test
    public void prob1Case3() {
        assertThat(Day2.manhattanSpiral(23), is(2));
    }

    @Test
    public void prob1Case4() {
        assertThat(Day2.manhattanSpiral(1024), is(31));
    }

    @Test
    public void prob1Case5() {
        assertThat(Day2.manhattanSpiral(4), is(1));
    }

    @Test
    public void prob2Case1() {
        assertThat(Day2.sumSpiral(1), is(2));
    }

    @Test
    public void prob2Case2() {
        assertThat(Day2.sumSpiral(2), is(4));
    }

    @Test
    public void prob2Case3() {
        assertThat(Day2.sumSpiral(24), is(25));
    }

    @Test
    public void prob2Case4() {
        assertThat(Day2.sumSpiral(122), is(133));
    }
}