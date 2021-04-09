package LeetCode_JAVA.DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/submissions/
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 *     所有数字（包括 target）都是正整数。
 *     解集不能包含重复的组合。
 */
public class CombinationSum {
    public void dfs(List<List<Integer>> res, List<Integer> one, int[] candidates, int sum, int target){
        if (sum == target){
            res.add(new ArrayList<>(one));
            return;
        }
        for (int i : candidates){
            if (one.size() >= 1 && i < one.get(one.size() - 1)) continue;
            if (sum + i > target) break;
            one.add(i);
            dfs(res, one, candidates, sum + i, target);
            one.remove(one.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, one, candidates, 0, target);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 5}, 8));
    }
}
