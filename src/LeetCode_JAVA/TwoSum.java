package LeetCode_JAVA;

import org.junit.Test;

public class TwoSum {
    public int[] twoSum(int[] nums, int target){
        int i=0, j=0;
        for(i = 0; i < nums.length; i++){
            for (j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{i,j};
    }

    @Test
    public void test(){
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result;
        result = twoSum(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
