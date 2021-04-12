package LeetCode_JAVA.TwoPointer;

import java.util.Arrays;

public class TwoSum3 {

    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int last = j;
        while (target < nums[j]) {
            last = j;
            j = (i + j) / 2;
        }
        j = last;
        while (i <= j) {
            int left = nums[i], right = nums[j];
            if (left + right < target) {
                i++;
            } else if (left + right > target) {
                j--;
            } else {
                return new int[]{left, right};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(new TwoSum3().twoSum(nums, 9)));
    }

}
