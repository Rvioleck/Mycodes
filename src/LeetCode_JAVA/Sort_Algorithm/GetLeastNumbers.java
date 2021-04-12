package LeetCode_JAVA.Sort_Algorithm;

import java.util.Arrays;

public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] arr, int left, int right, int k) {
        int pivotIndex = partition(arr, left, right);
        if (pivotIndex == k) {
            return Arrays.copyOf(arr, k + 1);
        }
        return pivotIndex > k ?
                quickSearch(arr, left, pivotIndex - 1, k) :
                quickSearch(arr, pivotIndex + 1, right, k);
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
}
