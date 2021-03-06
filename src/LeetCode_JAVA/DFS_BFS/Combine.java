package LeetCode_JAVA.DFS_BFS;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/submissions/
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Combine {
    private int n, k;

    private void dfs(List<List<Integer>> res, List<Integer> combination, int index) {
        if (combination.size() == k) {
            res.add(new ArrayList<>(combination));
            return;
        }
        for (int i = index; i <= n; i++) {
            combination.add(i);
            dfs(res, combination, i + 1);
            combination.remove(combination.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        this.n = n;
        this.k = k;
        List<Integer> combination = new ArrayList<>();
        dfs(res, combination, 1);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Combine().combine(4, 2));
    }
}
