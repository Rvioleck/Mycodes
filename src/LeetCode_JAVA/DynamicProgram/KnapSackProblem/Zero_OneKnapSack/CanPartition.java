package LeetCode_JAVA.DynamicProgram.KnapSackProblem.Zero_OneKnapSack;

/**
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 可以将原问题等价于0-1背包问题：是否可以从输入数组中挑选出一些正整数，使得这些数的和'等于'整个数组元素的和的一半。
 * dp[i][j]表示从下标集合{0..i}中任意挑选元素使得其和为j true || false
 * 其状态转移方程为dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
 */
public class CanPartition {

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[n][sum + 1];
        dp[0][0] = true;
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            dp[i][0] = true;
            for (int j = target; j >= 1; j--) {
                if (j >= nums[i])
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n - 1][target];
    }

    public boolean canPartition_OneDimension(int[] nums) {
        // 二维情形下的等价变换
        int n = nums.length;
        if (n <= 1) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        // dp[i][j]表示从下标集合{0..i}中任意挑选元素使得其和为j
        for (int i = 1; i < n; i++) {
            for (int j = target; j >= 1; j--) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(new CanPartition().canPartition_OneDimension(nums));
        System.out.println(new CanPartition().canPartition(nums));
    }

}
