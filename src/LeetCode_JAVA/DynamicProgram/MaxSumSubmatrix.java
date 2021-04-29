package LeetCode_JAVA.DynamicProgram;

import java.util.Arrays;

public class MaxSumSubmatrix {

    public static void main(String[] args) {
        int[][] matrix = {{5, -4, -3, 4}, {-3, -4, 4, 5}, {5, 1, 5, -4}};
        System.out.println(new MaxSumSubmatrix().maxSumSubmatrix(matrix, 10));
    }

    public int getAreaSum(int[][] matrix, int x, int y, int dx, int dy, int k) {
        int maxSum = Integer.MIN_VALUE;
        int[][] dp = new int[2][dy + 1];
        for (int i = 0; i <= dx; i++) {
            for (int j = 0; j <= dy; j++) {
                if (i >= 1 && j >= 1) {
                    dp[1][j] = dp[0][j] + dp[1][j - 1] - dp[0][j - 1];
                } else if (j >= 1) {
                    dp[1][j] = dp[1][j - 1];
                } else if (i >= 1) {
                    dp[1][j] = dp[0][j];
                }
                dp[1][j] += matrix[i + x][j + y];
                if (dp[1][j] <= k && dp[1][j] > maxSum) {
                    maxSum = dp[1][j];
                    if (maxSum == k) {
                        return k;
                    }
                }
            }
            dp[0] = Arrays.copyOf(dp[1], dy + 1);
        }
        return maxSum;
    }


    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int max = Integer.MIN_VALUE, sum;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum = getAreaSum(matrix, i, j, m - 1 - i, n - 1 - j, k);
                if (sum == k) {
                    return k;
                } else if (sum < k && sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

}
