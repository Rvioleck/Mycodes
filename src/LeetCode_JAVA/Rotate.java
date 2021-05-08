package LeetCode_JAVA;

import java.util.Arrays;

public class Rotate {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        new Rotate().rotate(matrix);
    }

    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int xi = 0, xj = m - 1, yi = 0, yj = n - 1;
        dfs(matrix, xi, xj, yi, yj);
        for (int[] row : matrix
             ) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void dfs(int[][] matrix, int xi, int xj, int yi, int yj){
        if (xi >= xj) return;
        int[] nums = new int[xj - xi];
        if (nums.length >= 0) System.arraycopy(matrix[xi], yi, nums, 0, nums.length);
        for (int i = 0; i < nums.length; ++i){
            matrix[xi][yi + i] = matrix[xj - i][yi];
        }
        for (int i = 0; i < nums.length; ++i){
            matrix[xj - i][yi] = matrix[xj][yj - i];
        }
        for (int i = 0; i < nums.length; ++i){
            matrix[xj][yj - i] = matrix[xi + i][yj];
        }
        for (int i = 0; i < nums.length; ++i){
            matrix[xi + i][yj] = nums[i];
        }
        dfs(matrix, xi + 1, xj - 1, yi + 1, yj - 1);
    }

}

