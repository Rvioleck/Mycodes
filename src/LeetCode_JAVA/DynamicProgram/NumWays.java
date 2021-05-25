package LeetCode_JAVA.DynamicProgram;

import java.util.Arrays;

public class NumWays {

    public static void main(String[] args) {
        int steps = 5, arrLen = 20;
        System.out.println(new NumWays().numWays(steps, arrLen));
        System.out.println(new NumWays().numWaysOptimise(steps, arrLen));
    }

    public int numWays(int steps, int arrLen) {
        int max = Math.min(steps / 2, arrLen - 1);
        int mod = (int) 1e9 + 7;
        int[][] dp = new int[steps + 1][max + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; ++i) {
            for (int j = 0; j <= Math.min(max, steps - i); ++j) {
                dp[i][j] = (dp[i][j] + dp[i - 1][j]) % mod;
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                }
                if (j + 1 <= max) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod;
                }
            }
        }
        return dp[steps][0];
    }

    public int numWaysOptimise(int steps, int arrLen) {
        int max = Math.min(steps / 2, arrLen - 1);
        int mod = (int) 1e9 + 7;
        int[][] dp = new int[2][max + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; ++i) {
            for (int j = 0; j <= Math.min(max, steps - i); ++j) {
                dp[1][j] = dp[0][j] % mod;
                if (j - 1 >= 0) {
                    dp[1][j] = (dp[1][j] + dp[0][j - 1]) % mod;
                }
                if (j + 1 <= max) {
                    dp[1][j] = (dp[1][j] + dp[0][j + 1]) % mod;
                }
            }
            dp[0] = Arrays.copyOf(dp[1], max + 1);
        }
        return dp[0][0];
    }

}
