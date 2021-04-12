package LeetCode_JAVA.DFS_BFS;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/submissions/
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        dfs(res, one, nums, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> one, int[] nums, int index) {
        res.add(new ArrayList<>(one));
        for (int i = index; i < nums.length; i++) {
            one.add(nums[i]);
            dfs(res, one, nums, i + 1);
            one.remove(one.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3}));
    }

}
