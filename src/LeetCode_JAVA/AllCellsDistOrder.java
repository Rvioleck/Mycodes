package LeetCode_JAVA;

import java.util.Arrays;

public class AllCellsDistOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                res[i * C + j] = new int[]{i, j};
            }
        }
        Arrays.sort(res, (arr1, arr2) -> (Math.abs(arr1[0] - r0) + Math.abs(arr1[1] - c0)) + (Math.abs(arr2[0] - r0) + Math.abs(arr2[1] - c0)));
        return res;
    }
}
