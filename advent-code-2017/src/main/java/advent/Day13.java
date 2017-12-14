package advent;

import java.util.*;

public class Day13 {

    private static String inputString = "0: 4\n" +
            "1: 2\n" +
            "2: 3\n" +
            "4: 4\n" +
            "6: 6\n" +
            "8: 5\n" +
            "10: 6\n" +
            "12: 6\n" +
            "14: 6\n" +
            "16: 12\n" +
            "18: 8\n" +
            "20: 9\n" +
            "22: 8\n" +
            "24: 8\n" +
            "26: 8\n" +
            "28: 8\n" +
            "30: 12\n" +
            "32: 10\n" +
            "34: 8\n" +
            "36: 12\n" +
            "38: 10\n" +
            "40: 12\n" +
            "42: 12\n" +
            "44: 12\n" +
            "46: 12\n" +
            "48: 12\n" +
            "50: 14\n" +
            "52: 14\n" +
            "54: 12\n" +
            "56: 12\n" +
            "58: 14\n" +
            "60: 14\n" +
            "62: 14\n" +
            "66: 14\n" +
            "68: 14\n" +
            "70: 14\n" +
            "72: 14\n" +
            "74: 14\n" +
            "78: 18\n" +
            "80: 14\n" +
            "82: 14\n" +
            "88: 18\n" +
            "92: 17\n";

    public static void main(String[] args) {
        System.out.println(prob1(inputString));
        System.out.println(prob2(inputString));
    }

    public static int prob1(String input) {
        Map<Integer, Integer> firewall = new HashMap<>();
        for (String line : input.split("\\r?\\n")) {
            String[] wall = line.split(":");
            int depth = Integer.valueOf(wall[0].trim());
            int range = Integer.valueOf(wall[1].trim());
            firewall.put(depth, range);
        }
        int score = 0;
        for (int i = 0; i <= max(firewall.keySet()); i++) {
            if (firewall.get(i) != null) {
                int cycles = (firewall.get(i) - 2) * 2 + 2;
                if (i % cycles == 0) {
                    score += firewall.get(i) * i;
                }
            }
        }
        return score;
    }

    public static int max(Collection<Integer> input) {
        int max = Integer.MIN_VALUE;
        for (int i : input) {
            if (i > max) max = i;
        }
        return max;
    }

    public static int prob2(String input) {
        Map<Integer, Integer> firewall = new HashMap<>();
        for (String line : input.split("\\r?\\n")) {
            String[] wall = line.split(":");
            int depth = Integer.valueOf(wall[0].trim());
            int range = Integer.valueOf(wall[1].trim());
            firewall.put(depth, range);
        }
        int i = 0;
        while (!run(firewall, i)) {
            i++;
        }
        return i;
    }

    public static boolean run(Map<Integer, Integer> firewall, int delay) {
        for (int i = 0; i <= max(firewall.keySet()); i++) {
            if (firewall.get(i) != null) {
                int cycles = (firewall.get(i) - 2) * 2 + 2;
                if ((i + delay) % cycles == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
