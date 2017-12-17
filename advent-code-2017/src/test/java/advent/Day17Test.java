package advent;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Day17Test {

    @Test
    public void case1() {
        assertThat(Day17.prob1(2017, 3), is(638));
    }

}