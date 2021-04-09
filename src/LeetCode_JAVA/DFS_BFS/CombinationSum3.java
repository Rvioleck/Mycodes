package LeetCode_JAVA.DFS_BFS;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-iii/submissions/
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 *     所有数字都是正整数。
 *     解集不能包含重复的组合。
 */
public class CombinationSum3 {
    private int k, n;

    private void dfs(List<List<Integer>> res, List<Integer> combination, int index, int sum) {
        if (sum == n && combination.size() == k) {
            res.add(new ArrayList<>(combination));
            return;
        }

        for (int i = index; i <= 9; i++) {
            if (sum + i > n) break;
            if (combination.size() > k) break;
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
