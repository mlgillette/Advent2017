package advent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day17 {

    private static int steps = 382;
    private static int max1 = 2017;
    private static int max2 = 50000000;

    public static void main(String[] args) {
        System.out.println(prob1(max1, steps));
        System.out.println(prob2(max2, steps));
    }

    public static int prob1(int max, int steps) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int current = 1;
        int index = 0;
        for (int j = 0; j < max; j++) {
            index = (index + steps) % list.size();
            if (index == list.size()) {
                list.add(current);
            } else {
                list.add(index + 1, current);
            }
            index = getNextIndex(list, index);
            current++;
        }
        return list.get(getNextIndex(list, index));
    }

    private static int getNextIndex(List<Integer> list, int index) {
        return list.size() > 0 ? (index + 1) % list.size() : 0;
    }


    public static int prob2(int max, int steps) {
        int current = 1;
        int index = 0;
        int result = 0;
        for (int j = 1; j <= max; j++) {
            index = (index + steps) % j;
            if (index == 0) {
                result = current;
            }
            index++;
            current++;
        }
        return result;
    }
}
