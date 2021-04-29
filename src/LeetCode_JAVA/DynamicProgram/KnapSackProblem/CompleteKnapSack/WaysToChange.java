package LeetCode_JAVA.DynamicProgram.KnapSackProblem.CompleteKnapSack;

/**
 * https://leetcode-cn.com/problems/coin-lcci/
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 */
public class WaysToChange {

    public static void main(String[] args) {
        int n = 30;
        System.out.println(new WaysToChange().waysToChange(n));
        System.out.println(new WaysToChange().waysToChange_optimise(n));
    }

    public int waysToChange(int n) {
        int[] coins = {1, 5, 10, 25};
        int[][] dp = new int[5][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= 4; i++) {
            dp[i][0] = 1;
            int coin = coins[i - 1];
            for (int j = 0; j <= n; j++) {
                if (j >= coin)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coin] % 1000000007;
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[4][n] % 1000000007;
    }

    public int waysToChange_optimise(int n) {
        int[] coins = {1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - coin]) % 1000000007;
            }
        }
        return dp[n];
    }
}
