package LeetCode_JAVA.DynamicProgram.KnapSackProblem.CompleteKnapSack.SimilarToCKS;

public class NumSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j <= Math.pow(i, 0.5); j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println(new NumSquares().numSquares(n));
    }

}
