package LeetCode_JAVA.DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets-ii/
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class SubsetsWithDup {

    private void dfs(List<List<Integer>> res, List<Integer> one, int[] nums, int index){
        res.add(new ArrayList<>(one));
        for (int i = index; i < nums.length; i++){
            if (i > index && nums[i] == nums[i - 1]) continue;  // 剪去同层的相同元素的枝
            one.add(nums[i]);
            dfs(res, one, nums, i + 1);
            one.remove(one.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, one, nums, 0);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SubsetsWithDup().subsetsWithDup(new int[]{1, 2, 2}));
    }

}
