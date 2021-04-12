package LeetCode_JAVA.Sort_Algorithm;

import java.util.Random;

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }

    private int quickSort(int[] nums, int left, int right, int k) {
        int pivotIdx = partition(nums, left, right);
        if (pivotIdx == k - 1) {
            return nums[pivotIdx];
        }
        return pivotIdx > k - 1 ?
                quickSort(nums, left, pivotIdx - 1, k) :
                quickSort(nums, pivotIdx + 1, right, k);
    }

    private int partition(int[] nums, int left, int right) {
        // 随机寻找pivot元素(并将其交换到第一个)
        int i = new Random().nextInt(right - left + 1) + left;
        int temp = nums[i];
        nums[i] = nums[left];
        nums[left] = temp;
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] <= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] >= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new FindKthLargest().findKthLargest(new int[]{1, 5, 4, 8, 7, 3, 2, 9}, 3));
    }

}
