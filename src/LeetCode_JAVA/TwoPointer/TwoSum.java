package LeetCode_JAVA.TwoPointer;

import java.util.Arrays;

public class TwoSum {

    private void quickSort(int[] nums, int left, int right){
        if (left < right){
            int pivotIdx = partition(nums, left, right);
            quickSort(nums, left, pivotIdx);
            quickSort(nums, pivotIdx + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right){
            while (left < right && pivot <= nums[right]){
                right--;
            }
            nums[right] = nums[left];
            while (left < right && pivot >= nums[left]){
                left++;
            }
            nums[left] = nums[right];
        }
        nums[left] = pivot;
        return left;
    }

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length - 1;
        quickSort(nums, 0, len);
        int i = 0, j = len;
        while (i <= j){
            int left = nums[i], right = nums[j];
            if (left + right < target){
                i++;
            } else if (left + right > target){
                j--;
            } else {
                return new int[]{i, j};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

}
