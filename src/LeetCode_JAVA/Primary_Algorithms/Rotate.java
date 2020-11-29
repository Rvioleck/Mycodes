package LeetCode_JAVA.Primary_Algorithms;

import org.junit.Test;

public class Rotate {
    public void rotate(int[] nums, int k){
        while (k-- != 0) {
            int last = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                nums[i + 1] = nums[i];
            }
            nums[0] = last;
        }
    }

    @Test
    public void test(){
        int[] nums = {-1, -100, 3, 99};
        int k = 2;
        rotate(nums, k);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
