package LeetCode_JAVA.DFS_BFS;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    private void dfs(int[] candidates ,List<List<Integer>> res, List<Integer> sum, int left){
        if (left == 0){
            res.add(new ArrayList<>(sum));
            return;
        }
        for (int i = candidates.length - 1; i >= 0; --i) {
            if (candidates[i] > left) continue;
            if (!sum.isEmpty() && candidates[i] > sum.get(0)) continue;
            left -= candidates[i];
            sum.add(0, candidates[i]);
            dfs(candidates, res, sum, left);
            left += candidates[i];
            sum.remove(0);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sum = new ArrayList<>();
        dfs(candidates, res, sum, target);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 5}, 8));
//        System.out.println(new CombinationSum().getSum(new ArrayList<>(Arrays.asList(2, 3, 6, 7))));
    }
}
