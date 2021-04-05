package LeetCode_JAVA.DynamicProgram.KnapSackProblem.CompleteKnapSack;

/**
 * https://leetcode-cn.com/problems/coin-change-2/
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * 典型的完全背包问题
 * 讨论组合个数时的状态转移方程为 dp[j] = dp[j] + dp[j - coin], dp[i][j] = dp[i - 1][j] + dp[i][j - coin];
 * 递推式和https://leetcode-cn.com/problems/target-sum/此题完全相同，但是本题本质是完全背包，那题是0-1背包
 *
 *  dp[i][j] = dp[i - 1][j] + dp[i - 1][j - coin] + dp[i - 1][j - 2 * coin] + ... + dp[i - 1][j - k * coin]
 *  dp[i][j - coin] = dp[i - 1][j - coin] + dp[i - 1][j - 2 * coin] + ... + dp[i - 1][j - k * coin]
 *  dp[i][j] = dp[i - 1][j] + dp[i][j - coin] 推导式与其巧合相同
 */

public class Change {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            int coin = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                // dp[i][j] = ①不选物品i的组合数(正好缺0个)，②正好缺1个coin的组合数,...,③正好缺k个coin的组合数，求和所得
                // 转移方程化简如下
                if (j >= coin){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coin];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }

    public int change_optimise(int amount, int[] coins) {
        // 二维数组的等价变换
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int coin = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                if (j >= coin){
                    dp[j] = dp[j] + dp[j - coin];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 3};
        int amount = 4;
        System.out.println(new Change().change(amount, coins));
        System.out.println(new Change().change_optimise(amount, coins));
    }

}
