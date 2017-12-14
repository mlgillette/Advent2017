package advent;

import java.util.ArrayList;
import java.util.List;

public class Day3 {
    private static int[] rowOne = {1640,590,93,958,73,1263,1405,1363,737,712,1501,390,68,1554,959,79};
    private static int[] rowTwo = {4209,128,131,2379,2568,2784,2133,145,3618,1274,3875,158,1506,3455,1621,3799};
    private static int[] rowThree = {206,1951,2502,2697,2997,74,76,78,1534,81,2775,2059,3026,77,2600,3067};
    private static int[] rowFour = {373,1661,94,102,2219,1967,1856,417,1594,75,100,2251,2200,1825,1291,1021};
    private static int[] rowFive = {57,72,51,1101,1303,60,1227,421,970,1058,138,333,1320,1302,402,1210};
    private static int[] rowSix = {4833,5427,179,3934,4533,5124,4832,2088,94,200,199,1114,4151,1795,208,3036};
    private static int[] rowSeven =   {759,876,110,79,1656,1691,185,544,616,312,757,1712,92,97,1513,1683};
    private static int[] rowEight =  {1250,1186,284,107,1190,1233,573,1181,1041,655,132,547,395,146,119,515};
    private static int[] rowNine = {505,1726,79,180,86,1941,1597,1785,1608,1692,968,1177,94,184,91,31};
    private static int[] rowTen =  {1366,2053,1820,1570,70,506,53,415,717,1263,82,366,74,1255,2020,1985};
    private static int[] rowEleven = {2365,5585,2285,4424,5560,3188,3764,187,88,223,1544,5023,4013,5236,214,196};
    private static int[] rowTwelve =  {1487,1305,1359,1615,6579,2623,4591,150,5030,188,146,4458,5724,5828,1960,221};
    private static int[] rowThirteen =  {3114,688,3110,334,1921,153,4083,131,2234,3556,3573,3764,127,919,3293,104};
    private static int[] rowFourteen = {1008,78,1196,607,135,1409,296,475,915,157,1419,1304,153,423,163,704};
    private static int[] rowFifteen = {235,4935,4249,3316,1202,221,1835,380,249,1108,1922,5607,4255,238,211,3973};
    private static int[] rowSixteen = {1738,207,179,137,226,907,1468,1341,1582,1430,851,213,393,1727,1389,632};
    private static int[][] puzzleInput = {rowOne, rowTwo, rowThree, rowFour, rowFive, rowSix, rowSeven, rowEight, rowNine, rowTen,
    rowEleven, rowTwelve, rowThirteen, rowFourteen, rowFifteen, rowSixteen};

    public static void main(String[] args) {
        System.out.println(checksum(puzzleInput));
        System.out.println(checksumTwo(puzzleInput));
    }

    static int checksum(int[][] spreadsheet) {
        int checksum = 0;
        for (int[] row: spreadsheet) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i: row) {
                if (i < min) min = i;
                if (i > max) max = i;
            }
            checksum += max - min;
        }
        return checksum;
    }

    static int checksumTwo(int[][] spreadsheet) {
        int checksum = 0;
        for (int[] row: spreadsheet) {
            for (int i = 0; i < row.length; i++) {
                for (int j = i + 1; j < row.length; j++) {
                    int max = Integer.max(row[i], row[j]);
                    int min = Integer.min(row[i], row[j]);
                    if (max % min == 0) {
                        checksum += max / min;
                        break;
                    }
                }
            }
        }
        return checksum;
    }
}
