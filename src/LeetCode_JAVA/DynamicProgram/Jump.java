package LeetCode_JAVA.DynamicProgram;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/jump-game-ii/
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * dp[i]: 跳跃到位置i需要的最少跳跃次数
 * 位置i的步长为num: dp[i + 1] = min(dp[i + 1], dp[i] + 1),
 *                dp[i + 2] = min(dp[i + 2], dp[i] + 1), ...,
 *                dp[i + num] = min(dp[i + num], dp[i] + 1)
 *
 * 初始条件：dp[1] = 0, dp[2~n] = ∞
 */
public class Jump {

    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for (int i = 1; i <= n; ++i) {
            int num = nums[i - 1];
            for (int j = i + 1; j <= i + num && j <= n; j++) { // 向前更新dp数组j <= n保证不越界
                // dp[i + 1]~dp[i + num] = dp[i] + 1
                // 假如i处的步数为2则dp[i + 1]与dp[i + 2]的元素全部为dp[i] + 1(如果更小)
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(new Jump().jump(nums));
    }
}
