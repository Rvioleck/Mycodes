package LeetCode_JAVA.DynamicProgram;

/**
 * dp[i]表示分拆数i可以得到的最大的乘积
 * 对于所有小于j<i存在：
 * dp[i] = max(j * (i - j), dp[j] * (i - j), dp[j] * dp[i - j])
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), Math.max(dp[j] * (i - j), dp[j] * dp[i - j])));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new IntegerBreak().integerBreak(n));
    }

}
