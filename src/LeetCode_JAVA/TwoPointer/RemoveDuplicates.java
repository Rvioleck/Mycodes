package LeetCode_JAVA.TwoPointer;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * 给你一个有序数组nums，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= 2 || nums[i] != nums[p - 2]){
                nums[p] = nums[i];
                p++;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(new RemoveDuplicates().removeDuplicates(nums));
    }

}
