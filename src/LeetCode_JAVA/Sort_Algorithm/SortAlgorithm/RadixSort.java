package LeetCode_JAVA.Sort_Algorithm.SortAlgorithm;

import java.util.Arrays;

public class RadixSort {
    // 基数排序

    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 3, 4, 7, 6, 1, 2, 5};
        System.out.println("Before: " + Arrays.toString(nums));
        new RadixSort().radixSort(nums);
        System.out.println("After: " + Arrays.toString(nums));
    }

    private void radixSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        radixSort(nums, 0, nums.length - 1, maxbits(nums));
    }

    public static int maxbits(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    public static void radixSort(int[] nums, int L, int R, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        // 有多少个数准备多少个辅助空间
        int[] bucket = new int[R - L + 1];
        for (int d = 1; d <= digit; ++d) {  // 有多少位就进出几次
            // count 各位数字小于等于i的数字有count[i]个（词频数组→前缀和数组）
            // 从右往左：保证了先入桶的先出桶，从而保证了排序过程的稳定性
            int[] count = new int[radix];
            for (i = L; i <= R; ++i) {
                j = getDigit(nums[i], d);
                count[j]++;   // 求词频数组
            }
            for (i = 1; i < radix; ++i) {
                count[i] += count[i - 1];  // 求前缀和数组
            }
            for (i = R; i >= L; --i) {
                j = getDigit(nums[i], d);
                bucket[count[j] - 1] = nums[i];
                count[j]--;
            }
            for (i = L, j = 0; i <= R; ++i, ++j) {
                nums[i] = bucket[j];
            }
        }
    }

    private static int getDigit(int num, int d) {
        d--;
        while (d != 0){
            num /= 10;
            d--;
        }
        return num % 10;
    }

}
