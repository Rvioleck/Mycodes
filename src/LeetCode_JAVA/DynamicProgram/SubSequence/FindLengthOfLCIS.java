package LeetCode_JAVA.DynamicProgram.SubSequence;

/**
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/submissions/
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1]
 * 那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 *
 *
 */
public class FindLengthOfLCIS {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(new FindLengthOfLCIS().findLengthOfLCIS(nums));
        System.out.println(new FindLengthOfLCIS().findLengthOfLCIS_optimise(nums));
    }

    public int findLengthOfLCIS(int[] nums){
        int n = nums.length;
        int[] dp = new int[n]; // dp[i]从下标0~i中以元素i结尾的最长子序列的长度
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            if (i >= 1 && nums[i] > nums[i - 1]){
                dp[i] += dp[i - 1];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int findLengthOfLCIS_optimise(int[] nums) {
        int dp0 = 1, dp1 = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++, dp1 = 1) {
            if (nums[i] > nums[i - 1]){
                dp1 += dp0;
            }
            dp0 = dp1;
            max = Math.max(max, dp0);
        }
        return max;
    }
}
