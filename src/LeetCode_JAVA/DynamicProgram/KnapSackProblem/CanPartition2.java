package LeetCode_JAVA.DynamicProgram.KnapSackProblem;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 可以将原问题等价于0-1背包问题：是否可以从输入数组中挑选出一些正整数，使得这些数的和'等于'整个数组元素的和的一半。
 * dp[i][j]表示前i个物品(下标1~i)中任意挑选元素使得其和为j true || false
 * 其状态转移方程为dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
 *
 * 其与CanPartition的主要区别在于dp[i][j]数组，本dp数组的i表示前i个物品，原dp数组的i表示下标0~i的前i+1个物品
 */
public class CanPartition2 {

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n <= 1){
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1){
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            dp[i][0] = true;
            for (int j = target; j >= 1; j--) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num)
                    dp[i][j] = dp[i][j] || dp[i - 1][j - num];
            }
        }
        return dp[n][target];
    }

    public boolean canPartition_OneDimension(int[] nums){
        // 二维情形下的等价变换
        int n = nums.length;
        if (n <= 1){
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1){
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(new CanPartition2().canPartition_OneDimension(nums));
        System.out.println(new CanPartition2().canPartition(nums));
    }

}
