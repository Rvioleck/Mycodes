package LeetCode_JAVA.Sort_Algorithm.SortAlgorithm;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {49, 38, 65, 97, 76, 13, 27, 49};
        System.out.println("Before: " + Arrays.toString(nums));
        new MergeSort().mergeSort(nums);
        System.out.println("After: " + Arrays.toString(nums));
    }

    public void mergeSort(int[] nums) {
        int len = nums.length;
        divideSolve(nums, 0, len - 1);
    }

    public void divideSolve(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left - (left - right) / 2;
            divideSolve(nums, left, mid);
            divideSolve(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[nums.length];
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left, j = mid + 1, k;
        for (k = left; i <= mid && j <= right; k++) {
            if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
            }
        }
        while (i <= mid) nums[k++] = temp[i++];
        while (j <= right) nums[k++] = temp[j++];
    }

}
