package LeetCode_JAVA.BitwiseOperation;

/**
 * https://leetcode-cn.com/problems/single-number/
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 1, 5, 4, 5, 3};
        System.out.println(new SingleNumber().singleNumber(nums));
    }
}
