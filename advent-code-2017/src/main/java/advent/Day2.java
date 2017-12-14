package advent;

public class Day2 {

    public static void main(String[] args) {
        System.out.println(manhattanSpiral(265149));
        System.out.println(sumSpiral(265149));
    }

    static int manhattanSpiral(int start) {
        int k =(int) Math.ceil((Math.sqrt(start)-1)/2);
        int t = 2 * k + 1;
        int m = t * t;
        t--;

        int x, y;
        if (start>=m-t) {
            x = k - (m - start);
            y = -k;
            return coordDiff(k, x, y);
        } else {
            m = m-t;
        }
        if (start>=m-t) {
            x = -k;
            y = -k + (m - start);
            return coordDiff(k, x, y);
        } else {
            m = m-t;
        }
        if (start>=m-t) {
            x = -k + (m - start);
            y = k;
        } else {
            x = k;
            y = k-(m-start-t);
        }
        return coordDiff(k, x, y);
    }

    static int coordDiff(int k, int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }

    static int sumSpiral(int start) {
        int center = (int) Math.ceil((Math.sqrt(start + 1)-1)/2);
        int side = 2 * center + 1;
        Integer[][] spiralArray = new Integer[side][side];
        spiralArray[center][center] = 1;
        int max = 1;
        int x = center;
        int y = center;
        int step = 1;

        while (max <= start) {
            for (int i = 1; i <= step; i++) {
                if (step % 2 == 0) {
                    x--;
                } else {
                    x++;
                }
                spiralArray[x][y] = sumAdjacent(spiralArray, x, y);
                if (spiralArray[x][y] > max) max = spiralArray[x][y];
                if (max > start) return max;
            }
            for (int i = 1; i <= step; i++) {
                if (step % 2 == 0) {
                    y--;
                } else {
                    y++;
                }
                spiralArray[x][y] = sumAdjacent(spiralArray, x, y);
                if (spiralArray[x][y] > max) max = spiralArray[x][y];
                if (max > start) return max;
            }
            step++;
        }
        return max;
    }

    static int sumAdjacent(Integer[][] arr, int x, int y) {
        int sum = 0;
        for (int arrX = x - 1; arrX <= x + 1; arrX++) {
            if (arrX >= 0 && arrX < arr.length) {
                for (int arrY = y - 1; arrY <= y + 1; arrY++) {
                    if (arrY >= 0 && arrY < arr[arrX].length) {
                        Integer val = arr[arrX][arrY];
                        sum += val == null ? 0 : val;
                    }
                }
            }
        }
        return sum;
    }
}
