package LeetCode_JAVA.DynamicProgram.SubSequence;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 */
public class MinDistance2 {

    public static void main(String[] args) {
        String word1 = "intention", word2 = "execution";
        System.out.println(new MinDistance2().minDistance(word1, word2));
        System.out.println(new MinDistance2().minDistance_optimise(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
            for (int j = 1; j <= n; j++) {
                char a = word1.charAt(i - 1), b = word2.charAt(j - 1);
                if (a == b) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
        return dp[m][n];
    }

    public int minDistance_optimise(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[2][n + 1];
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            dp[1][0] = i;
            for (int j = 1; j <= n; j++) {
                char a = word1.charAt(i - 1), b = word2.charAt(j - 1);
                if (a == b) {
                    dp[1][j] = dp[0][j - 1];
                } else {
                    dp[1][j] = Math.min(dp[0][j - 1] + 1, Math.min(dp[0][j] + 1, dp[1][j - 1] + 1));
                }
            }
            dp[0] = Arrays.copyOf(dp[1], n + 1);
        }
        return dp[0][n];
    }

}
