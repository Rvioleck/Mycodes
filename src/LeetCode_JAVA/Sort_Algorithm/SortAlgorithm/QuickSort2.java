package LeetCode_JAVA.Sort_Algorithm.SortAlgorithm;

import java.util.Arrays;
import java.util.Random;

public class QuickSort2 {
    /**
     * 荷兰国旗思想作为partition实现的快排算法
     */

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4, 5, 0, 9, 8, 1, 2};
        new QuickSort2().quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void quickSort(int[] nums, int left, int right){
        if (left >= right) return;
        int[] pivot = partition(nums, left, right);
        quickSort(nums, left, pivot[0]);
        quickSort(nums, pivot[1], right);
    }

    public void swap(int[] nums, int a, int b){
        if (a == b) return;
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }

    public int[] partition(int[] nums, int left, int right){
        // 此处partition的思想为荷兰国旗问题
        int rand = new Random().nextInt(right - left + 1) + left;
        swap(nums, rand, left);
        int pivot = nums[left];
        int less = left - 1, more = right + 1, i = left;
        while (i < more){
            if (nums[i] < pivot){
                swap(nums, i++, ++less);
            } else if (nums[i] == pivot){
                i++;
            } else{
                swap(nums, i, --more);
            }
        }
        return new int[]{less, more};
    }
}
