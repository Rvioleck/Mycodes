package LeetCode_JAVA.DynamicProgram.SubSequence;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/is-subsequence/
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）
 * <p>
 * dp[i][j]: A的前i+1(0~i)的i个元素和B的前j+1(0~j)的j个元素的最长公共子序列的长度
 * dp[i][j] = dp[i - 1][j - 1] + 1;                  (A[i] == B[j])
 * dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j])   (A[i] != B[j])
 */
public class IsSubsequence {

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(new IsSubsequence().isSubsequence(s, t));
        System.out.println(new IsSubsequence().isSubsequence_optimise(s, t));
    }

    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            int a = s.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                int b = t.charAt(j - 1);
                if (a == b) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n] == m;
    }

    public boolean isSubsequence_optimise(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[2][n + 1];
        for (int i = 1; i <= m; i++) {
            int a = s.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                int b = t.charAt(j - 1);
                if (a == b) {
                    dp[1][j] = dp[0][j - 1] + 1;
                } else {
                    dp[1][j] = Math.max(dp[1][j - 1], dp[0][j]);
                }
            }
            dp[0] = Arrays.copyOf(dp[1], n + 1);
        }
        return dp[0][n] == m;
    }
}
