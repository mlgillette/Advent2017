package advent;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for simple Day1.
 */
public class Day1Test
{

    @Test
    public void dayOneProbOneCaseOne() {
        assertThat(Day1.dayOneProb1("1122"), is(3));
    }

    @Test
    public void dayOneProbOneCaseTwo() {

        assertThat(Day1.dayOneProb1("1111"), is(4));
    }

    @Test
    public void dayOneProbOneCaseThree() {
        assertThat(Day1.dayOneProb1("1234"), is(0));
    }

    @Test
    public void dayOneProbOneCaseFour() {
        assertThat(Day1.dayOneProb1("91212129"), is(9));
    }

    @Test
    public void dayOneProbTwoCaseOne() {
        assertThat(Day1.dayOneProb2("1212"), is(6));
    }

    @Test
    public void dayOneProbTwoCaseTwo() {
        assertThat(Day1.dayOneProb2("1221"), is(0));
    }

    @Test
    public void dayOneProbTwoCaseThree() {
        assertThat(Day1.dayOneProb2("123425"), is(4));
    }

    @Test
    public void dayOneProbTwoCaseFour() {
        assertThat(Day1.dayOneProb2("123123"), is(12));
    }

    @Test
    public void dayOneProbTwoCaseFive() {
        assertThat(Day1.dayOneProb2("12131415"), is(4));
    }
}
