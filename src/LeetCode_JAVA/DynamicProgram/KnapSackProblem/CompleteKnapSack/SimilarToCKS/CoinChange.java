package LeetCode_JAVA.DynamicProgram.KnapSackProblem.CompleteKnapSack.SimilarToCKS;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 同样是每个硬币可以使用多次，其类似于完全背包问题，但并不是完全背包问题
 * dp[i]：为组成金额i所需最少的硬币数量 (初始化为MAX_VALUE表示没有组合)
 * 状态转移方程：dp[i] = min{dp[i - coin[0]], dp[i - coin[1]], ..., dp[i - coin[k]]} + 1 (其中i - coin[k] >= 0)
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        System.out.println(new CoinChange().coinChange(coins, amount));
    }

}
