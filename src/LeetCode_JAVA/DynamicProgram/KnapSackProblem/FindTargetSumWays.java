package LeetCode_JAVA.DynamicProgram.KnapSackProblem;

public class FindTargetSumWays {
    final int N = 2000; // 防止下标溢出，整体下标+1000

    public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
        // dp[i][j]记录下标为{0..i}的任意元素之和为j的组合个数
        int[][] dp = new int[n][1 + N];
        dp[0][nums[0] + N / 2] = 1;
        dp[0][-nums[0] + N / 2] += 1;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = -N / 2; j <= N / 2; j++) {
                if (dp[i - 1][j + N / 2] > 0){
                    dp[i][j + num + N / 2] += dp[i - 1][j + N / 2];
                    dp[i][j - num + N / 2] += dp[i - 1][j + N / 2];
                }
            }
        }
        return S > N / 2 ? 0 : dp[n - 1][S + N / 2];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int S = 1;
        System.out.println(new FindTargetSumWays().findTargetSumWays(nums, S));
    }

}
