package LeetCode_JAVA.DynamicProgram;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            nums[i] = Math.max(nums[i], nums[i - 1] + nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

}
