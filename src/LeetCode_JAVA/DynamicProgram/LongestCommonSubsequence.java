package LeetCode_JAVA.DynamicProgram;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * dp[i][j]: 数组A的前i+1个元素(下标0~i个)元素和数组B的前j+1个元素(下标0~j)的最长公共子序列的长度
 *
 * dp[i][j] = dp[i - 1][j - 1] + 1 (A[i] = B[j])
 * dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]) (A[i] != B[j])
 *
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String text1 = "abcba", text2 = "abcbcba";
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence(text1, text2));
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence_optimise(text1, text2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char word1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char word2 = text2.charAt(j - 1);
                if (word1 == word2){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public int longestCommonSubsequence_optimise(String text1, String text2){
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[2][n + 1];
        for (int i = 1; i <= m; i++) {
            char word1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char word2 = text2.charAt(j - 1);
                if (word1 == word2){
                    dp[1][j] = dp[0][j - 1] + 1;
                } else {
                    dp[1][j] = Math.max(dp[0][j], dp[1][j - 1]);
                }
            }
            dp[0] = Arrays.copyOf(dp[1], n + 1);
            Arrays.fill(dp[1], 0);
        }
        return dp[0][n];
    }
}
