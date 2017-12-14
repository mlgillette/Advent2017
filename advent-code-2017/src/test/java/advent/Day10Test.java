package advent;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Day10Test {

    @Test
    public void case1() {
        assertThat(Day10.prob1(5, new int[] {3,4,1,5}), is(12));
    }

    @Test
    public void case2() {
        assertThat(Day10.prob2(""), is("a2582a3a0e66e6e86e3812dcb672a272"));
        assertThat(Day10.prob2("AoC 2017"), is("33efeb34ea91902bb2f59c9920caa6cd"));
        assertThat(Day10.prob2("1,2,3"), is("3efbe78a8d82f29979031a4aa0b16a9d"));
        assertThat(Day10.prob2("1,2,4"), is("63960835bcdc130f0b66d7ff4f6a5a8e"));
    }
}