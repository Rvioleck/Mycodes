package LeetCode_JAVA.DynamicProgram.SubSequence;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 */
public class LongestPalindromeSubseq {

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(new LongestPalindromeSubseq().longestPalindromeSubseq(s));
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[2][n];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if (i == j) {
                    dp[0][j] = 1;
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    dp[0][j] = dp[1][j - 1] + 2;
                } else {
                    dp[0][j] = Math.max(dp[1][j], dp[0][j - 1]);
                }
            }
            dp[1] = Arrays.copyOf(dp[0], n);
        }
        return dp[1][n - 1];
    }

}
