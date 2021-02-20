package LeetCode_JAVA.DFS_BFS;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    private int k, n;
    private void dfs(List<List<Integer>> res, List<Integer> combination, int index, int sum){
        if (sum == n && combination.size() == k){
            res.add(new ArrayList<>(combination));
            return;
        }

        for (int i = index; i <= 9; i++) {
            if (sum > n) continue;
            if (combination.size() > k) continue;
            combination.add(i);
            dfs(res, combination, i + 1, sum + i);
            combination.remove(combination.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        this.k = k;
        this.n = n;
        dfs(res, combination, 1, 0);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum3().combinationSum3(1, 3));
    }
}
