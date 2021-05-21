package LeetCode_JAVA.TwoPointer.BinarySearch;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 */
public class SearchRange {

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(new SearchRange().searchRange(nums, 8)));
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{search(nums, target, false), search(nums, target, true)};
    }

    public int search(int[] nums, int target, boolean leftOrRight){
        int left = 0, right = nums.length, res = -1;
        while (left < right){
            int mid = left - (left - right) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid;
            } else {
                res = mid;
                if (!leftOrRight){
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }

}
