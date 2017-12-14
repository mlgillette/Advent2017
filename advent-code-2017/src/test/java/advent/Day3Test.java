package advent;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Day3Test {

    @Test
    public void basicTest() {
        int[] rowOne = {5,1,9,5};
        int[] rowTwo = {7,5,3};
        int[] rowThree = {2,4,6,8};

        int[][] spreadsheet = {rowOne, rowTwo, rowThree};

        assertThat(Day3.checksum(spreadsheet), is(18));
    }

    @Test
    public void partTwoTest() {
        int[] rowOne = {5,9,2,8};
        int[] rowTwo = {9,4,7,3};
        int[] rowThree = {3,8,6,5};

        int[][] spreadsheet = {rowOne, rowTwo, rowThree};

        assertThat(Day3.checksumTwo(spreadsheet), is(9));
    }
}