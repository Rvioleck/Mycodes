package LeetCode_JAVA.TwoPointer;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * 给你一个有序数组nums，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 */
public class RemoveDuplicates2 {

    public int removeDuplicates(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < 2 || nums[p - 2] != nums[i]) {
                nums[p++] = nums[i];
            }
        }
        return p;
    }

    public int removeDuplicatesK(int[] nums, int k) {
        // 由于是保留 k 个相同数字，对于前 k 个数字，我们可以直接保留。
        // 对于后面的任意数字，能够保留的前提是：与当前写入的位置前面的第 k 个元素进行比较，不相同则保留。
        int n = nums.length;
        if (n <= 1) return n;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (idx < k || nums[idx - k] != nums[i]) {
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(new RemoveDuplicates2().removeDuplicates(nums));
    }

}
