package LeetCode_JAVA;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < dp.length; i++) {
            int dp_pre = Math.min(dp[i - 1], dp[i - 2]);
            if (i != cost.length)
                dp[i] = dp_pre + cost[i];
            else
                dp[i] = dp_pre;
        }
        return dp[dp.length - 1];
    }

    public int minCostClimbingStairs2(int[] cost) {
        int f0 = cost[0];
        int f1 = cost[1];
        for (int i = 2; i < cost.length; i++) {
            if (i % 2 == 0)
                f0 = Math.min(f0, f1) + cost[i];
            else
                f1 = Math.min(f0, f1) + cost[i];
        }
        return Math.min(f0, f1);
    }
}
