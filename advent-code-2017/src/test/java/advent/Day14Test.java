package advent;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Day14Test {

    @Test
    public void hex2Bin() {
        assertThat(Day14.hexToBin("a0c2017"), is("1010000011000010000000010111"));
    }

    @Test
    public void case1() {
        assertThat(Day14.prob1("flqrgnkx"), is(8108));
    }

    @Test
    public void case2() {
        assertThat(Day14.prob2("flqrgnkx"), is(1242));
    }

}