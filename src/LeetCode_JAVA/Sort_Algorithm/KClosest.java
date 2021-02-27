package LeetCode_JAVA.Sort_Algorithm;

import java.util.Arrays;

public class KClosest {

    public int[][] kClosest(int[][] points, int K) {
        // 自定义排序法
        Arrays.sort(points, (x, y) -> (int)(
                Math.pow(x[0], 2) + Math.pow(x[1], 2) -
                        (Math.pow(y[0], 2) + Math.pow(y[1], 2))
                ));
        return Arrays.copyOf(points, K);
    }

    public static void main(String[] args) {
        int[][] res = new KClosest().kClosest(new int[][]{
                {1, 2},
                {2, 0},
                {-2, 2},
                {3, 1},
                {4, 0},
                {1, -1}
        }, 3);
        for (int[] one:
             res) {
            System.out.println(Arrays.toString(one));
        }
    }

}
