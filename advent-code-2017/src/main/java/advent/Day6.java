package advent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day6 {
    static int[] input = new int[] {2,8,8,5,4,2,3,1,5,5,1,2,15,13,5,14};

    public static void main(String[] args) {
        System.out.println(prob1(input));
        System.out.println(prob2(input));
    }

    static int prob1(int[] input) {
        Set<String> seen = new HashSet<>();
        String stringRep = intArrToString(input);
        int cycles = 0;
        while (!seen.contains(stringRep)) {
            seen.add(stringRep);
            int maxIndex = findMaxIndex(input);
            redistribute(input, maxIndex);
            stringRep = intArrToString(input);
            cycles++;
        }
        return cycles;
    }

    static String intArrToString(int[] input) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : input) {
            sb.append(i);
        }
        return sb.toString();
    }

    private static void redistribute(int[] input, int maxIndex) {
        int toSpread = (int) Math.ceil((double) input[maxIndex] / input.length);
        int total = input[maxIndex];
        input[maxIndex] = 0;
        for(int i = 1; i <= input.length; i++) {
            input[(i + maxIndex) % input.length] += Math.min(toSpread,Math.max(total,0));
            total -= toSpread;
        }
    }

    private static int findMaxIndex(int[] input) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] > max) {
                max = input[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    static int prob2(int[] input) {
        Map<String, Integer> seen = new HashMap<>();
        String stringRep = intArrToString(input);
        int cycles = 0;
        while (!seen.keySet().contains(stringRep)) {
            seen.put(stringRep, cycles);
            int maxIndex = findMaxIndex(input);
            redistribute(input, maxIndex);
            stringRep = intArrToString(input);
            cycles++;
        }
        return cycles - seen.get(stringRep);
    }


    static int[] stringToIntArray(String input) {
        String[] lines = input.split("\\r?\\n");
        int[] ints = new int[lines.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.valueOf(lines[i]);
        }
        return ints;
    }
}
