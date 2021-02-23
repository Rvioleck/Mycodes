package LeetCode_JAVA;

import java.util.Random;

public class SortArray {
    public int partition(int[] nums, int low, int high) {
        int i = new Random().nextInt(high - low + 1) + low;
        int temp = nums[i];
        nums[i] = nums[high];
        nums[high] = temp;

        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot)
                high--;
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot)
                low++;
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }

    public void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivotPos = partition(nums, low, high);
            quickSort(nums, low, pivotPos - 1);
            quickSort(nums, pivotPos + 1, high);
        }
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void main(String[] args) {
        int[] res = new SortArray().sortArray(new int[]{5, 3, 8, 1, 9, 2});
        for (int i :
                res) {
            System.out.print(i + " ");
        }
    }
}
