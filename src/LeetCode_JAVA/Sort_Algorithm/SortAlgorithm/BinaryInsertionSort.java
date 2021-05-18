package LeetCode_JAVA.Sort_Algorithm.SortAlgorithm;

import LeetCode_JAVA.TwoPointer.BinarySearch.BinarySearchTemplate;

import java.util.Arrays;

public class BinaryInsertionSort {

    public static void main(String[] args) {
        int[] nums = {49, 38, 65, 97, 76, 13, 27, 49};
        System.out.println("Before: " + Arrays.toString(nums));
        new BinaryInsertionSort().binarySort(nums);
        System.out.println("After: " + Arrays.toString(nums));
    }

    public void binarySort(int[] nums){
        int i, j, low, high, mid;
        // 初值i = 1表示已维护好的序列默认有一个元素nums[0]
        for (i = 1; i < nums.length; ++i){
            int temp = nums[i];           // 记录待插入元素的副本
            low = 0; high = i - 1;        // 设置二分查找的范围
            while (low <= high){          // 折半查找
                mid = high + (low - high) / 2;
                if (nums[mid] > temp) high = mid - 1;
                else low = mid + 1;
            }
            for (j = i - 1; j >= high + 1; --j){
                // 从后往前查找待插入位置
                nums[j + 1] = nums[j];
                // 向后挪位(将大于元素nums[i]的元素后移)
            }
            nums[high + 1] = temp;
        }
    }
}
