package LeetCode_JAVA;

import java.util.Arrays;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            if (nums[i] + dp[i - 1] > nums[i])
                dp[i] = nums[i] + dp[i - 1];
            else
                dp[i] = nums[i];
        }
        int result = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (result < dp[i])
                result = dp[i];
        }
        return result;
//        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        MaxSubArray obj = new MaxSubArray();
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(obj.maxSubArray(a));
    }

}
