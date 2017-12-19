package advent;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Day18Test {

    @Test
    public void case1() {
        String input = "set a 1\n" +
        "add a 2\n" +
        "mul a a\n" +
        "mod a 5\n" +
        "snd a\n" +
        "set a 0\n" +
        "rcv a\n" +
        "jgz a -1\n" +
        "set a 1\n" +
        "jgz a -2";
        assertThat(Day18.prob1(input), is(4L));
    }

    @Test
    public void case2() {
        String input = "snd 1\n" +
                "snd 2\n" +
                "snd p\n" +
                "rcv a\n" +
                "rcv b\n" +
                "rcv c\n" +
                "rcv d";

        assertThat(Day18.prob2(input), is(3));
    }

}