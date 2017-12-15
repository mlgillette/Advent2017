package advent;

import java.util.ArrayList;
import java.util.List;

public class Day15 {

    private static String inputString = "Generator A starts with 783\n" +
            "Generator B starts with 325\n";

    private static long factorA = 16807;
    private static long factorB = 48271;

    private static long divisor = 2147483647;

    public static void main(String[] args) {
        String[] inputs = inputString.split("\\r?\\n");
        String[] inputA = inputs[0].split(" ");
        String[] inputB = inputs[1].split(" ");
        System.out.println(prob1(inputA[inputA.length - 1], inputB[inputB.length -1]));
        System.out.println(prob2(inputA[inputA.length - 1], inputB[inputB.length -1]));
    }

    public static int prob1(String a, String b) {
        return prob1(a,b,40000000);
    }

    public static int prob1(String a, String b, int max) {
        long aInt = Long.parseLong(a);
        long bInt = Long.parseLong(b);
        int count = 0;
        for (int i = 0; i < max; i++) {
            aInt = aInt * factorA % divisor;
            bInt = bInt * factorB % divisor;
            String aBin = String.format("%16s", Long.toBinaryString(aInt)).replace(" ", "0");
            String bBin = String.format("%16s", Long.toBinaryString(bInt)).replace(" ", "0");

            if (aBin.substring(aBin.length() - 16).equals(bBin.substring(bBin.length() - 16))) {
                count++;
            }
        }

        return count;
    }

    public static Ret prob2(String inputA, String inputB, int max) {
        long aInt = Long.parseLong(inputA);
        long bInt = Long.parseLong(inputB);
        List<String> aJudge = new ArrayList<>();
        List<String> bJudge = new ArrayList<>();
        Ret ret = new Ret(aJudge, bJudge);
        int min = 0;
        while (min < max) {
            aInt = aInt * factorA % divisor;
            bInt = bInt * factorB % divisor;
            if (aInt % 4 == 0) ret.a.add(String.format("%32s", Long.toBinaryString(aInt)).replace(" ", "0"));
            if (bInt % 8 == 0) ret.b.add(String.format("%32s", Long.toBinaryString(bInt)).replace(" ", "0"));
            min = Math.min(aJudge.size(), bJudge.size());
        }
        return ret;
    }

    public static int prob2(String inputA, String inputB) {
        Ret ret = prob2(inputA, inputB, 5000000);
        int count = 0;
        for (int i = 0; i < 5000000; i++) {
            if (ret.a.get(i).substring(ret.a.get(i).length() - 16).equals
                    (ret.b.get(i).substring(ret.b.get(i).length() - 16))) {
                count++;
            }
        }
        return count;
    }

    public static class Ret {
        List<String> a;
        List<String> b;

        public Ret(List<String> a, List<String> b) {
            this.a = a;
            this.b = b;
        }
    }
}
