package LeetCode_JAVA.DynamicProgram.KnapSackProblem.CompleteKnapSack.SimilarToCKS;

/**
 * https://leetcode-cn.com/problems/perfect-squares/
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 * dp[i]：组成数字i的完全平方数的和的个数
 * dp[i] = min(dp[i - 1*1], dp[i - 2*2], ..., dp[i - j*j])  其中i >= j*j
 * 初始条件 dp[i] = i 初始化数字i由i个1组成，则组成和个数为i
 */

public class NumSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 初始化最大值，此时都由1组成时
            for (int j = 1; j <= Math.pow(i, 0.5); j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println(new NumSquares().numSquares(n));
    }

}
