package LeetCode_JAVA;

import org.junit.Test;

public class SingleNumber {
    public int singleNumber(int[] nums){
        int single = 0;
        for (int num: nums
             ) {
            single ^= num;
        }
        return single;
    }

    @Test
    public void test(){
        int[] nums = {1, 2, 3, 2, 1, 5, 4, 5, 3};
        System.out.println(singleNumber(nums));
    }
}
