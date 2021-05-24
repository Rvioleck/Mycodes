package LeetCode_JAVA.DynamicProgram.SubSequence;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/strange-printer/
 * 有台奇怪的打印机有以下两个特殊要求：
 *
 *     打印机每次只能打印由 同一个字符 组成的序列。
 *     每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 *
 * 给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。
 */
public class StrangePrinter {

    public static void main(String[] args) {
        String s = "ababc";
        System.out.println(new StrangePrinter().strangePrinter(s));
    }

    /**
     * @param s 所打印的字符串s
     * @return 最少需要的打印次数
     * dp[i][j]表示区间i到j需要的最少打印次数
     * s[i] == s[j]: dp[i][j] = dp[i][j - 1]
     * s[i] != s[j]: dp[i][j] = min(dp[i][k] + dp[k + 1][j])
     *
     * dp[i][j] 依赖于 dp[i + k][j]和dp[i][j - k]，逆序i，顺序j
     */
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            // 初始化：dp[i][j] = MAX_VALUE, dp[i][i] = 1
            Arrays.fill(dp[i], 0x3f3f3f3f);
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                char si = s.charAt(i), sj = s.charAt(j);
                if (si == sj){
                    dp[i][j] = dp[i][j - 1];
                } else {
                    for (int k = i; k < j; ++k){
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

}
