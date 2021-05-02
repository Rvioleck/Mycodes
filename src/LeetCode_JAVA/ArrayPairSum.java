package LeetCode_JAVA;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/array-partition-i/
 */
public class ArrayPairSum {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2){
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new ArrayPairSum().arrayPairSum(new int[]{1, 4, 3, 2}));
    }

}
