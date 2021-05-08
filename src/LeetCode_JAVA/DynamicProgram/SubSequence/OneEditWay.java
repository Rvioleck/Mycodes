package LeetCode_JAVA.DynamicProgram.SubSequence;

/**
 * https://leetcode-cn.com/problems/one-away-lcci/
 */
public class OneEditWay {

    public static void main(String[] args) {
        String first = "pale", second = "paee";
        System.out.println(new OneEditWay().oneEditAway(first, second));
    }

    public boolean oneEditAway(String first, String second) {
        int m = first.length(), n = second.length();
        if (Math.abs(m - n) > 1) return false;
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j <= n; ++j){
            dp[0][j] = j;
        }
        for(int i = 1; i <= m; ++i){
            dp[i][0] = i;
            for (int j = 1; j <= n; ++j){
                char a = first.charAt(i - 1), b = second.charAt(j - 1);
                if (a != b){
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n] <= 1;
    }
}
