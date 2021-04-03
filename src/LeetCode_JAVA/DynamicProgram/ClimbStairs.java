package LeetCode_JAVA.DynamicProgram;

import org.junit.Test;

public class ClimbStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    @Test
    public void test() {
        System.out.println(climbStairs(2));
    }
}
