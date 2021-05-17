package LeetCode_JAVA.Sort_Algorithm.SortAlgorithm;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {49, 38, 65, 97, 76, 13, 27, 49};
        System.out.println("Before: " + Arrays.toString(nums));
        new BubbleSort().insertSort(nums);
        System.out.println("After: " + Arrays.toString(nums));
    }

    public void insertSort(int[] nums){
        for (int i = 0; i < nums.length - 1; ++i){
            boolean flag = false;     // 表示本次冒泡排序是否发生交换(优化传统冒泡)
            for (int j = nums.length - 1; j > i; --j){
                if (nums[j - 1] > nums[j]){ // 如果后者更小，向前交换
                    // 交换nums[j]和nums[j - 1](使用异或进行交换优化传统冒泡)
                    // a = a ^ b, b = b ^ (a ^ b) = a, a = a ^ (a ^ b) = b
                    nums[j - 1] ^= nums[j];
                    nums[j] ^= nums[j - 1];
                    nums[j - 1] ^= nums[j];
                    flag = true;    // 标识产生交换
                }
                if (!flag) return;  // 一次冒泡未发生交换，说明已经有序
            }
        }
    }
}
