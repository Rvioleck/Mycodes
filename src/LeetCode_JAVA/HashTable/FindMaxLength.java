package LeetCode_JAVA.HashTable;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/contiguous-array/
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 */
public class FindMaxLength {

    public static void main(String[] args){
        int[] nums = new int[]{1, 0, 1, 0, 0, 1};
        System.out.println(new FindMaxLength().findMaxLength(nums));
        System.out.println(new FindMaxLength().findMaxLength2(nums));
    }

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; ++i){
            // sums[0] = 0;
            sums[i] = sums[i - 1] + (nums[i - 1] == 1 ? 1 : -1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 2; i <= n; ++i){
            // 从0开始记录前缀和的下标位置, 第一个元素为map[0, 0];
            if (!map.containsKey(sums[i - 2])) map.put(sums[i - 2], i - 2);
            // 如果有前缀和的值和现在的值相同，则之间的子数组之和为0，满足条件
            // 此时其长度为两下标之差
            if (map.containsKey(sums[i])) ans = Math.max(ans, i - map.get(sums[i]));
        }
        return ans;
    }

    public int findMaxLength2(int[] nums){
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; ++i){
            sums[i] = sums[i - 1] + (nums[i - 1] == 1 ? 1 : -1);
        }
        // 数组模拟哈希表
        int[] hash = new int[2 * n + 1];
        Arrays.fill(hash, -1);
        int ans = 0;
        for (int i = 2; i <= n; ++i){
            if (hash[sums[i - 2] + n] == -1) hash[sums[i - 2] + n] = i - 2;
            if (hash[sums[i] + n] != -1) ans = Math.max(ans, i - hash[sums[i] + n]);
        }
        return ans;
    }

}
