package advent;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Day6Test {

    @Test
    public void case1() {
        int[] input = new int[] {0,2,7,0};
        assertThat(Day6.prob1(input), is(5));
    }

    @Test
    public void case2() {
        int[] input = new int[] {0,2,7,0};
        assertThat(Day6.prob2(input), is(4));
    }

}