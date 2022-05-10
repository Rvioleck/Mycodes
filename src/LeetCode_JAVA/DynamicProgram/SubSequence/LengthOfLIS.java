package LeetCode_JAVA.DynamicProgram.SubSequence;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class LengthOfLIS {

    public static void main(String[] args) {
        int[] nums = {7,7,7,7,7,7,7};
        System.out.println(new LengthOfLIS().lengthOfLIS(nums));
        System.out.println(new LengthOfLIS().lengthOfLIS2(nums));
    }

    public int lengthOfLIS(int[] nums) {
        // 时间复杂度：O(n²)，空间复杂度：O(n)
        int n = nums.length;
        // dp[i]表示i之前(必须包括i)的最长上升子序列
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int lengthOfLIS2(int[] nums) {
        // 时间复杂度：O(nlogn)，空间复杂度：O(n)
        int n = nums.length;
        // 长度为i+1的递增子序列的最大值为end[i]
        // end本身一定为一个严格递增数组，所以才可以二分
        // 原因：更长的子序列的最大值一定比更短的子序列的最大值要大
        int[] end = new int[n];
        int res = 0;
        for (int i = 0; i < n; ++i){
            res = Math.max(res, getEndOfNumMaxLen(i, end, nums[i]));
        }
        return res;
    }

    public int getEndOfNumMaxLen(int i, int[] end, int num){
        // 找到以num为最大值结尾的子序列的最大长度
        end[i] = Integer.MAX_VALUE;
        int left = 0, right = i;
        // 二分找到end数组中比num大的第一个数的下标并更新
        while (left < right){
            int mid = ((left + right) >> 1);
            if (num > end[mid]){
                left = mid + 1;
            } else if (num <= end[mid]){
                right = mid;
            }
        }
        end[left] = num; // 更新此前的长度为left+1的子序列的最大值
        // 下标为left,其最长递增子序列长度为left+1(end数组含义)
        return left + 1;
    }
}
