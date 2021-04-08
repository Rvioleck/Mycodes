package LeetCode_JAVA.TwoPointer.SlideWindow;

/**
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回0
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int l = 0;
        int windowSum = 0;
        int windowLen = 0;
        for (int num : nums) {
            windowSum += num;
            windowLen++;
            while (windowSum >= target) {
                minLen = Math.min(minLen, windowLen);
                windowSum -= nums[l];
                l++;
                windowLen--;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(new MinSubArrayLen().minSubArrayLen(target, nums));
    }
}
