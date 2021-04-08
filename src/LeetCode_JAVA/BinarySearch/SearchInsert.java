package LeetCode_JAVA.BinarySearch;


/**
 * https://leetcode-cn.com/problems/search-insert-position/submissions/
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0)
            return 0;
        if (nums[len - 1] < target)
            return len;
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else
                high = mid;
        }
        return low;
    }

    public int searchInsert2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > target){
                right = mid - 1;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right + 1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 7};
        System.out.println(new SearchInsert().searchInsert(nums, 7));
        System.out.println(new SearchInsert().searchInsert2(nums, 7));
    }


}
