package LeetCode_JAVA.Sort_Algorithm.SortAlgorithm;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
        int[] nums = {49, 38, 65, 97, 76, 13, 27, 49};
        System.out.println("Before: " + Arrays.toString(nums));
        new SelectSort().selectSort(nums);
        System.out.println("After: " + Arrays.toString(nums));
    }

    public void selectSort(int[] nums){
        for (int i = 0; i < nums.length - 1; ++i){
            int min = i;  // min记录num[i~n-1]的最小元素的下标
            for (int j = i + 1; j < nums.length; ++j){
                if (nums[j] < nums[min]){
                    // 有更小元素则更新下标min
                    min = j;
                }
            }
            if (min != i){ // 交换最小值nums[min]和nums[i]的位置
                nums[i] ^= nums[min];
                nums[min] ^= nums[i];
                nums[i] ^= nums[min];
            }
        }
    }

}
