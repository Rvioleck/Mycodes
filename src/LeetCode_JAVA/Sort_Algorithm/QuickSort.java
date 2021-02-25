package LeetCode_JAVA.Sort_Algorithm;

import java.util.Arrays;

public class QuickSort {

    public void quickSort(int[] nums, int left, int right){
        if (left < right){
            int pivot = partition(nums, left, right);
            quickSort(nums, left, pivot);
            quickSort(nums,  pivot + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivotVal = nums[left];
        while (left < right){
            while (left < right && nums[right] >= pivotVal){
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivotVal){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivotVal;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4,5,0,9,8,1,2};
        new QuickSort().quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

}
