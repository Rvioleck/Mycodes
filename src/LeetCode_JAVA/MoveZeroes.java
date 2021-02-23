package LeetCode_JAVA;

import org.junit.Test;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j++] = nums[i];
                nums[i] = temp;
            }
        }
    }

    @Test
    public void test() {
        int[] nums = {5, 0, 4, 3, 0, 2, 1};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "");
        }
    }
}
