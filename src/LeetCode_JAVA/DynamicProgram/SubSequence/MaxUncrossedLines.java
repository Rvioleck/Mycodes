package LeetCode_JAVA.DynamicProgram.SubSequence;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/uncrossed-lines/
 * 我们在两条独立的水平线上按给定的顺序写下 A 和 B 中的整数。
 * 现在，我们可以绘制一些连接两个数字 A[i] 和 B[j] 的直线，只要 A[i] == B[j]，且我们绘制的直线不与任何其他连线（非水平线）相交。
 * 以这种方法绘制线条，并返回我们可以绘制的最大连线数。
 *
 * dp[i][j]: 只考虑A的前i+1个元素(0~i)和B的前j+1个元素(0~j)的情况下，最大连线数
 *
 * dp[i][j] = dp[i - 1][j - 1] + 1 (A[i] == B[j])
 * dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])  (A[i] != B[j])
 *
 */
public class MaxUncrossedLines {

    public static void main(String[] args) {
        int[] A = new int[]{1,4,2};
        int[] B = new int[]{1,2,4};
        System.out.println(new MaxUncrossedLines().maxUncrossedLines(A, B));
        System.out.println(new MaxUncrossedLines().maxUncrossedLines_optimise(A, B));
    }

    public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            int a = A[i - 1];
            for (int j = 1; j <= n; j++) {
                int b = B[j - 1];
                if (a == b){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    private int maxUncrossedLines_optimise(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[][] dp = new int[2][n + 1];
        for (int i = 1; i <= m; i++) {
            int a = A[i - 1];
            for (int j = 1; j <= n; j++) {
                int b = B[j - 1];
                if (a == b){
                    dp[1][j] = dp[0][j - 1] + 1;
                } else {
                    dp[1][j] = Math.max(dp[0][j], dp[1][j - 1]);
                }
            }
            dp[0] = Arrays.copyOf(dp[1], n + 1);
        }
        return dp[0][n];
    }
}
