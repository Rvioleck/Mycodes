package LeetCode_JAVA.BitwiseOperation;

/**
 * https://leetcode-cn.com/problems/missing-number/
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(new MissingNumber().missingNumber(nums));
    }

    public int missingNumber(int[] nums) {
        // T = 1 ^ 2 ^ 3 ^ ... ^ x ^ ... ^ n
        // Y = 1 ^ 2 ^ 3 ^ ... ^ ... ^ n
        // x = T ^ Y
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            x = x ^ i ^ nums[i];
        }
        return x ^ nums.length;
    }

}
