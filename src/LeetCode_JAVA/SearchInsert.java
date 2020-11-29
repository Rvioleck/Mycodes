package LeetCode_JAVA;

import org.junit.Test;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0)
            return 0;
        if (nums[len-1] < target)
            return len;
        int low = 0;
        int high = nums.length - 1;
        while (low < high){
            int mid = low + (high - low) / 2;
            if (nums[mid] < target){
                low = mid + 1;
            }else
                high = mid;
        }
        return low;
    }

    @Test
    public void test(){
        int[] nums = {2, 3, 5, 7};
        System.out.println(searchInsert(nums, 7));
    }
}
