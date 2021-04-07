package LeetCode_JAVA.DynamicProgram.SubSequence;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * dp[i]: 前i+1个元素(1~i)(包含下标i的元素)的连续子数组和最大值
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            nums[i] = Math.max(nums[i], nums[i - 1] + nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public int maxSubArray_optimise(int[] nums){
        int n = nums.length;
        int dp0 = 0, dp1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            dp1 = Math.max(num, dp0 + num);
            max = Math.max(max, dp1);
            dp0 = dp1;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new MaxSubArray().maxSubArray_optimise(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

}
