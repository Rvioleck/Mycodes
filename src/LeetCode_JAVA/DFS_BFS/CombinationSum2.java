package LeetCode_JAVA.DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    private boolean[] vis;
    private void dfs(int[] candidates, List<List<Integer>> res, List<Integer> sum, int left){
        if (left == 0){
            res.add(new ArrayList<>(sum));
            return;
        }
        for (int i = candidates.length - 1; i >= 0; --i) {
            if (vis[i]) continue;
            if (candidates[i] > left) continue;
            if (!sum.isEmpty() && candidates[i] > sum.get(0)) continue;
            if (i > 0 && candidates[i] == candidates[i - 1] && !vis[i - 1]) continue;
            vis[i] = true;
            left -= candidates[i];
            sum.add(0, candidates[i]);

            dfs(candidates, res, sum, left);

            vis[i] = false;
            left += candidates[i];
            sum.remove(0);
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sum = new ArrayList<>();
        vis = new boolean[candidates.length];
        dfs(candidates, res, sum, target);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum2().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5} ,8));
    }
}
