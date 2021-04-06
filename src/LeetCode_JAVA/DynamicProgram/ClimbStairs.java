package LeetCode_JAVA.DynamicProgram;

import org.junit.Test;

public class ClimbStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs_optimize(int n) {
        int dp1 = 1, dp2 = 2;
        if (n == 1) {
            return dp1;
        }
        if (n == 2) {
            return dp2;
        }
        int dpNext = 0;
        for (int i = 3; i <= n; i++) {
            dpNext = dp1 + dp2;
            dp1 = dp2;
            dp2 = dpNext;
        }
        return dpNext;
    }

    @Test
    public void test() {
        System.out.println(climbStairs(4));
        System.out.println(climbStairs_optimize(4));
    }
}
