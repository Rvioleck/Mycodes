package LeetCode_JAVA.DynamicProgram.SubSequence;

/**
 * https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 *
 * dp[i][j]: 只考虑s的前i+1个元素(0~i)(包含i)和t的前j+1个元素(0~j)(包含j)的情况下，s和t的最小步数
 *
 * word1[i] == word2[j]: dp[i][j] = dp[i - 1][j - 1];
 * word2[i] != word2[j]: dp[i][j] = min(min(dp[i - 1][j], dp[i][j - 1]) + 1, dp[i - 1][j - 1] + 2)
 *
 * dp[i][0] = 1 (0 <= i <= m) dp[0][j] = 1 (0 <= j <= n)
 */
public class MinDistance {

    public static void main(String[] args) {
        String word1 =  "leetcode", word2 = "etco";
        System.out.println(new MinDistance().minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            int a = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                int b = word2.charAt(j - 1);
                if (a == b){
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]) + 1, dp[i - 1][j - 1] + 2);
                }
            }
        }
        return dp[m][n];
    }

}
