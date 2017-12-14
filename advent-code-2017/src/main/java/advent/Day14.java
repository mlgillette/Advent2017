package advent;

import org.apache.commons.lang3.StringUtils;
import sun.swing.StringUIClientPropertyKey;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Day14 {

    private static String inputString = "stpzcrnm";

    public static void main(String[] args) {
        System.out.println(prob1(inputString));
        System.out.println(prob2(inputString));
    }

    public static String hexToBin(String hex) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hex.length(); i++) {
            Integer binInt = Integer.parseInt(Character.toString(hex.charAt(i)), 16);
            String bin = String.format("%4s", Integer.toBinaryString(binInt)).replace(" ", "0");
            sb.append(bin);
        }
        return sb.toString();
    }

    public static int prob1(String input) {
        int count = 0;
        for (int i = 0; i < 128; i++) {
            String val = input + "-" + i;
            String hex = Day10.prob2(val);
            count += StringUtils.countMatches(hexToBin(hex),"1");
        }
        return count;
    }

    public static int prob2(String input) {
        int count = 0;
        String[] binArr = new String[128];
        Integer[][] marks = new Integer[128][128];
        for (int i = 0; i < 128; i++) {
            String val = input + "-" + i;
            String hex = Day10.prob2(val);
            binArr[i] = hexToBin(hex);
        }

        for (int i = 0; i < 128; i++) {
            for (int j = 0; j < 128; j++) {
                count += walkAndMark(binArr, marks, i, j);
            }
        }
        return count;
    }

    public static int walkAndMark(String[] source, Integer[][] marks, int i, int j) {
        if (marks[i][j] != null || source[i].charAt(j) == '0') return 0;
        if (source[i].charAt(j) == '1') {
            marks[i][j] = 1;
            if (j < marks[i].length - 1) walkAndMark(source, marks, i, j+1);
            if (j > 0) walkAndMark(source, marks, i, j-1);
            if (i > 0) walkAndMark(source, marks, i-1, j);
            if (i < marks.length - 1) walkAndMark(source, marks, i+1, j);
        }
        return 1;
    }
}
