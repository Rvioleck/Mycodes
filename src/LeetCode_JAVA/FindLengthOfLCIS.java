package LeetCode_JAVA;

import org.junit.Test;

public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int result = 1;
        int now = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i])
                now += 1;
            else {
                if (now > result) {
                    result = now;
                    now = 1;
                } else
                    now = 1;
            }
        }
        if (now > result)
            result = now;
        return result;
    }

    @Test
    public void test() {
        int[] nums = {6, 2, 3, 4, 5};
        System.out.println(findLengthOfLCIS(nums));
    }
}
