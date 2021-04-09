package LeetCode_JAVA.DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：
 *     所有数字（包括目标数）都是正整数。
 *     解集不能包含重复的组合。
 */
public class CombinationSum2 {

    public void dfs(List<List<Integer>> res, List<Integer> one, int[] candidates, int index, int sum, int target){
        if (sum == target){
            res.add(new ArrayList<>(one));
            return;
        }
        for (int i = index; i < candidates.length; i++){
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            // i = index时即第一个枝的重复元素则为首次出现，保留第一次
            // i > index时即大于第一个枝时的重复元素需要剪枝
            // 保留不同层相同元素，剪去同层相同元素
            //       1
            //   2 (  2    2  )  第二层的第二个和第三个均被剪枝
            // 2 (2  2 2  2  2 ) 第三层除了第一个均被剪枝
            if (sum + candidates[i] > target) break;
            one.add(candidates[i]);
            dfs(res, one, candidates, i + 1, sum + candidates[i], target);
            one.remove(one.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, one, candidates, 0, 0, target);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum2().combinationSum2(new int[]{1, 2, 2, 2}, 5));
    }
}
