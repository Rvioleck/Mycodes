package LeetCode_JAVA.Sort_Algorithm;

import java.util.Arrays;

public class SortColors {
    /**
    * https://leetcode-cn.com/problems/sort-colors/
    */

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        // [0, left]记录0， [right, end]记录2
        int left = -1, right = nums.length;
        int i = 0;
        while (i < right){ // 当i遍历到right时停止，此时右侧全是2
            if (nums[i] == 0){
                // 扩大left域，并将0交换进来，继续向下走
                swap(nums, i++, ++left);
            } else if (nums[i] == 1){
                i++;  // 中间域全是1，直接走
            } else if (nums[i] == 2){
                // 左扩right域，将2交换进来，交换出来的值继续遍历
                swap(nums, i, --right);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0, 2, 1, 0, 0, 1, 2, 0};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
