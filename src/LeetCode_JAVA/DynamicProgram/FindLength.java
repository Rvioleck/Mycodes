package LeetCode_JAVA.DynamicProgram;

/**
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * dp[i][j]: 数组A的前i+1个元素(下标0~i个)元素和数组B的前j+1个元素(下标0~j)的最长公共数组
 *
 * dp[i][j] = dp[i - 1][j - 1] + 1 (A[i] == B[j])
 * dp[i][j] = 0  (A[i] != B[j])
 */
public class FindLength {

    public int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            int a = A[i - 1];
            for (int j = 1; j <= n; j++) {
                int b = B[j - 1];
                if (a == b){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0; // 压缩到dp[j]时此步不能省略，但是二维状态可以省略
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public int findLength_optimise(int[] A, int[] B){
        int m = A.length, n = B.length;
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            int a = A[i - 1];
            for (int j = n; j >= 1; j--) {
                int b = B[j - 1];
                if (a == b){
                    dp[j] = dp[j - 1] + 1;
                } else {
                    dp[j] = 0;
                }
                max = Math.max(max, dp[j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};
        System.out.println(new FindLength().findLength(A, B));
        System.out.println(new FindLength().findLength_optimise(A, B));
    }
}
