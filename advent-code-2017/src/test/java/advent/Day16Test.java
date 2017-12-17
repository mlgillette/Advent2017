package advent;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Day16Test {


    @Test
    public void case1() {
        assertThat(Day16.prob1(5, "s1,x3/4,pe/b"), is("baedc"));
    }

    @Test
    public void case2() {
        assertThat(Day16.prob2(5, "s1,x3/4,pe/b"), is("baedc"));
    }

}