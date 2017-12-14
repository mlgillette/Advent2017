package advent;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Day4Test {

    @Test
    public void prob1Case1() {
        assertThat(Day4.prob1Valid("aa bb cc dd ee"), is(true));
    }

    @Test
    public void prob1Case2() {
        assertThat(Day4.prob1Valid("aa bb cc dd aa"), is(false));
    }

    @Test
    public void prob1Case3() {
        assertThat(Day4.prob1Valid("aa bb cc dd aaa"), is(true));
    }
//
//    @Test
//    public void prob1Case4() {
//        assertThat(Day4.prob1Valid("aa bb cc dd ee"), is(true));
//    }

}