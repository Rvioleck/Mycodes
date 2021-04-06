package LeetCode_JAVA.DynamicProgram.KnapSackProblem.Zero_OneKnapSack;

/**
 * https://leetcode-cn.com/problems/target-sum/
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
 * 对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 */
public class FindTargetSumWays {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(new FindTargetSumWays().findTargetSumWays(nums, S));
        System.out.println(new FindTargetSumWays().findTargetSumWays_TwoDimension(nums, S));
        System.out.println(new FindTargetSumWays().findTargetSumWays_OneDimension(nums, S));
    }

    public int findTargetSumWays(int[] nums, int S) {
        final int N = 2000; // 防止下标溢出，整体下标+1000
        // 不推荐此解解此题
        int n = nums.length;
        // dp[i][j]记录下标为{0..i}的任意元素之和为j的组合个数
        int[][] dp = new int[n][N + 1];
        dp[0][nums[0] + N / 2] = 1;
        dp[0][-nums[0] + N / 2] += 1;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = -N / 2; j <= N / 2; j++) {
                if (dp[i - 1][j + N / 2] > 0) {
                    dp[i][j + num + N / 2] += dp[i - 1][j + N / 2];
                    dp[i][j - num + N / 2] += dp[i - 1][j + N / 2];
                }
            }
        }
        return S > N / 2 ? 0 : dp[n - 1][S + N / 2]; // 如果目标值越界，结果为0
    }

    /**
     * @param nums 记sum = Σnums
     * @param S    设正数之和是x,负数之和是y，则x + y = sum, x - y = S
     *             x = (sum + S)/2
     *             问题转化为从nums[]数组中找出和为x的组合的个数
     *             为动态规划解组合问题(该问题类似于0-1背包问题)
     *             前i个物品组合的和为j的组合的个数 =
     *             (不选第i个物品)前i-1个物品组合已经为j的个数 +
     *             (选第i个物品)前i-1个物品组合恰好为i-num的个数
     *             dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num];
     */
    public int findTargetSumWays_TwoDimension(int[] nums, int S) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (S > sum || (S + sum) % 2 == 1) {
            // 假设加法的总和为x，那么减法对应的总和就是sum - x
            // 所以我们要求的是 x - (sum - x) = S可得2 * x = S + sum
            // S + sum为奇数时无解
            return 0;
        }
        int m = (sum + S) / 2;
        // dp[i][j]记录前i个物品(下标1~i)和为j的组合的个数
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1; // 此处应该在一维情形下应该单独循环初始化
            // 因为本身逻辑就是单独初始化，仅仅在二维中可以恰好放入迭代体中初始化
            int num = nums[i - 1];
            for (int j = 0; j <= m; j++) {
                if (j - num >= 0) {
                    // 前i个物品组合的和为j的组合的个数 =
                    //   (不选第i个物品)前i-1个物品组合已经为j的个数 +
                    //   (选第i个物品)前i-1个物品组合恰好为i-num的个数
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }

    private int findTargetSumWays_OneDimension(int[] nums, int S) {
        // 等价转换为一维数组
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (S > sum || (S + sum) % 2 == 1) {
            return 0;
        }
        int m = (sum + S) / 2;
        // 上述将问题转化为动态规划求组合问题(该问题类似于0-1背包问题)
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = m; j >= num; j--) {
                dp[j] = dp[j] + dp[j - num];
            }
        }
        return dp[m];
    }

}
