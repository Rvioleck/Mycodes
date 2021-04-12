package LeetCode_JAVA.Sort_Algorithm;

import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        int[] temp = new int[len];
        divide(nums, 0, len - 1, temp);
    }

    public void divide(int[] nums, int left, int right, int[] temp) {
        if (left >= right) return;
        int mid = left - (left - right) / 2;
        divide(nums, left, mid, temp);
        divide(nums, mid + 1, right, temp);
        merge(nums, left, mid, right, temp);
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                nums[k] = temp[j++];
            } else if (j > right) {
                nums[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 9, 8, 4, 5, 7, 6};
        new MergeSort().mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
