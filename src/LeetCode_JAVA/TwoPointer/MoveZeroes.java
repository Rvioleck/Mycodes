package LeetCode_JAVA.TwoPointer;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; ++i){
            if (nums[i] != 0){
                nums[idx] = nums[i];
                idx++;
            }
        }
        for (int i = idx; i < nums.length; ++i){
            nums[i] = 0;
        }
    }
}
