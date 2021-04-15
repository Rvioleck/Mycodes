package Alogrithms;

import java.util.Arrays;

public class _02_递归插入排序 {

    public static void insertSort(int[] arr, int k){
        if (k == 0){
            // 递归出口
            return;
        }
        // 对前k-1个元素排序
        insertSort(arr, k - 1);
        int x = arr[k];
        int index = k - 1;
        while (index > - 1 && x < arr[index]){
            arr[index + 1] = arr[index--];
        }
        arr[index + 1] = x;
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 0, 9, 8, 10, 7, 2};
        insertSort(nums, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
