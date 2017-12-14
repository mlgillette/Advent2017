package advent;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Day9Test {


    @Test
    public void case1() {
        assertThat(Day9.prob1("{}"), is(1));
        assertThat(Day9.prob1("{{{}}}"), is(6));
        assertThat(Day9.prob1("{{},{}}"), is(5));
        assertThat(Day9.prob1("{{{},{},{{}}}}"), is(16));
        assertThat(Day9.prob1("{<a>,<a>,<a>,<a>}"), is(1));
        assertThat(Day9.prob1("{{<ab>},{<ab>},{<ab>},{<ab>}}"), is(9));
        assertThat(Day9.prob1("{{<!!>},{<!!>},{<!!>},{<!!>}}"), is(9));
        assertThat(Day9.prob1("{{<a!>},{<a!>},{<a!>},{<ab>}}"), is(3));
    }

    @Test
    public void case2() {
        assertThat(Day9.prob2("<>"), is(0));
        assertThat(Day9.prob2("<random characters>"), is(17));
        assertThat(Day9.prob2("<<<<>"), is(3));
        assertThat(Day9.prob2("<{!>}>"), is(2));
        assertThat(Day9.prob2("<!!>"), is(0));
        assertThat(Day9.prob2("<!!!>>"), is(0));
        assertThat(Day9.prob2("<{o\"i!a,<{i<a>"), is(10));
    }
}