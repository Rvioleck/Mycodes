package LeetCode_JAVA;

import java.util.Arrays;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int most = (int) Math.floor(nums.length / 2);
        Arrays.sort(nums);
        return nums[most];
    }
}
