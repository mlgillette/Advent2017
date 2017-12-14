package advent;

import java.util.Stack;

public class Day10 {

    private static int[] input = new int[] {63,144,180,149,1,255,167,84,125,65,188,0,2,254,229,24};

    private static String inputString = "63,144,180,149,1,255,167,84,125,65,188,0,2,254,229,24";

    public static void main(String[] args) {
        System.out.println(prob1(256, input));
        System.out.println(prob2(inputString));
    }

    public static int prob1(int circle, int[] lengths) {
        int[] circleList = new int[circle];
        for (int i = 0; i < circle; i++) {
            circleList[i] = i;
        }
        knotHash(circleList, lengths, 0, 0);

        return circleList[0] * circleList[1];
    }

    private static SkipPos knotHash(int[] circle, int[] lengths, int skip, int pos) {

        for (int i : lengths) {
            int max = pos + i;
            invert(circle, pos, max);
            pos += (i + skip) % circle.length;
            skip++;
        }
        return new SkipPos(skip, pos);
    }

    public static void invert(int[] list, int min, int max) {
        Stack<Integer> reverser = new Stack<>();
        for (int i = min; i < max; i++) {
            reverser.push(list[i % list.length]);
        }
        for (int i = min; i < max; i++) {
            list[i % list.length] = reverser.pop();
        }
    }

    public static String prob2(String input) {
        int[] circleList = new int[256];
        for (int i = 0; i < 256; i++) {
            circleList[i] = i;
        }
        int[] lengths = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            lengths[i] = (int) input.charAt(i);
        }
        int[] additions = new int[] {17, 31, 73, 47, 23};
        int[] newLengths = new int[lengths.length + 5];
        for (int i = 0; i < lengths.length; i++) {
            newLengths[i] = lengths[i];
        }
        for (int i = 0; i < 5; i++) {
            newLengths[lengths.length + i] = additions[i];
        }
        int skip = 0;
        int pos = 0;
        for (int i = 0; i < 64; i++) {
            SkipPos skipPos = knotHash(circleList, newLengths, skip, pos);
            skip = skipPos.skip;
            pos = skipPos.pos;
        }

        int[] denseHash = new int[16];
        for (int i = 0; i < 16; i++) {
            denseHash[i] = circleList[i * 16];
            for (int j = 1; j < 16; j++) {
                denseHash[i] = denseHash[i] ^ circleList[i * 16 + j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : denseHash) {
            sb.append(String.format("%02X", i).toLowerCase());
        }

        return sb.toString();
    }


    public static class SkipPos {
        public int pos;
        public int skip;

        public SkipPos(int skip, int pos) {
            this.skip = skip;
            this.pos = pos;
        }
    }
}
