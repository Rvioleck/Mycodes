package LeetCode_JAVA.Sort_Algorithm.SortAlgorithm;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] nums = {49, 38, 65, 97, 76, 13, 27, 49};
        System.out.println("Before: " + Arrays.toString(nums));
        new ShellSort().insertSort(nums);
        System.out.println("After: " + Arrays.toString(nums));
    }

    public void insertSort(int[] nums){
        int i, j;
        // 初值i = 1表示已维护好的序列默认有一个元素nums[0]
        for (int d = nums.length / 2; d >= 1; d /= 2){
            // 步长d 每次取d = d/2
            for (i = d; i < nums.length; i += d){
                // 依次将元素nums[1]~nums[len - 1]插入已维护好的有序序列
                // 所插入元素nums[i]大于以维护好的有序序列的最大元素则仍然有序，不执行操作
                // 否则执行该if操作
                if (nums[i] < nums[i - d]){
                    int temp = nums[i];
                    // 记录当前插入的元素副本
                    for (j = i - d; j >= 0 && nums[j] > temp; j -= d){
                        // 从后往前查找待插入位置
                        nums[j + d] = nums[j];
                        // 向后挪位(将大于元素nums[i]的元素后移)
                    }
                    nums[j + d] = temp;
                    // 复制到所找到的插入位置
                }
            }
        }
    }
}
