package LeetCode_JAVA.HashTable;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/continuous-subarray-sum/
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 *     子数组大小 至少为 2 ，且
 *     子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
 */
public class CheckSubarraySum {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,5};
        int k = 4;
        System.out.println(new CheckSubarraySum().checkSubarraySum(nums, k));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        // 前缀和
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; ++ i){
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 2; i <= n; ++i){
            // 同余定理：m % k = a且n % k = a则 (m - n) % k = 0
            set.add(prefix[i - 2] % k); // 初始添加进了0
            if (set.contains(prefix[i] % k)) return true; // 相当于从prefix的第二个有效数据开始
        }
        return false;
    }
}
