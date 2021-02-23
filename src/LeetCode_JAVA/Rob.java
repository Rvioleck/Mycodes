package LeetCode_JAVA;

import org.junit.Test;

public class Rob {
    public int rob(int[] nums) {
        // 打家劫舍（非相邻数组和值最大）
        if (nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return nums[0];
        else if (nums.length == 2) {
            if (nums[0] > nums[1])
                return nums[0];
            return nums[1];
        } else {
            if (nums[1] < nums[0])
                nums[1] = nums[0];
            for (int i = 2; i < nums.length; i++) {
                if (nums[i] + nums[i - 2] < nums[i - 1])
                    nums[i] = nums[i - 1];
                else
                    nums[i] += nums[i - 2];
            }
            if (nums[nums.length - 1] > nums[nums.length - 2])
                return nums[nums.length - 1];
            return nums[nums.length - 2];
        }
    }

    @Test
    public void testRob() {
        int[] nums = new int[]{2, 1, 1, 2};
        System.out.println(rob(nums));
    }
}
