package LeetCode_JAVA.DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/largest-divisible-subset/
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 *
 *     answer[i] % answer[j] == 0 ，或
 *     answer[j] % answer[i] == 0
 *
 * 如果存在多个有效解子集，返回其中任何一个均可。
 * dfs超时
 */
public class LargestDivisibleSubset {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(nums));
    }

    List<Integer> res = new ArrayList<>();

    public void dfs(List<Integer> combine, int[] nums, int idx){
        if (combine.size() > res.size()){
            res = new ArrayList<>(combine);
        }
        for (int i = idx; i < nums.length; i++){
            if (!satisfy(combine, nums[i])) continue;
            if (res.size() - combine.size() > nums.length - idx) break;
            combine.add(nums[i]);
            dfs(combine, nums, i + 1);
            combine.remove(combine.size() - 1);
        }
    }

    public boolean satisfy(List<Integer> combine, int x){
        for (int num : combine){
            if (num % x != 0 && x % num != 0){
                return false;
            }
        }
        return true;
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> combine = new ArrayList<>();
        Arrays.sort(nums);
        dfs(combine, nums, 0);
        return res;
    }

}
