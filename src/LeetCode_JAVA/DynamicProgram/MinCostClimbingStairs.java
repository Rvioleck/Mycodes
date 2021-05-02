package LeetCode_JAVA.DynamicProgram;

/**
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(new MinCostClimbingStairs().climbStairs(cost));
    }

    public int climbStairs(int[] cost) {
        int n = cost.length;
        if (n <= 1) {
            return 0;
        }
        int[] dp = new int[n]; //dp[i]爬到第i层花费的最少体力
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

}
