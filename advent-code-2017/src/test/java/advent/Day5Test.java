package advent;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Day5Test {

    @Test
    public void case1() {
        int[] input = new int[] {0, 3, 0, 1, -3};

        assertThat(Day5.prob1(input), is(5));
    }

    @Test
    public void case2() {
        int[] input = new int[] {0, 3, 0, 1, -3};

        assertThat(Day5.prob2(input), is(10));
    }

}