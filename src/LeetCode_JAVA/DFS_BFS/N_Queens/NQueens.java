package LeetCode_JAVA.DFS_BFS.N_Queens;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    /*
     * https://leetcode-cn.com/problems/n-queens/
     * */

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] record = new int[n];
        dfs(0, n, record, res);
        return res;
    }

    public void dfs(int i, int n, int[] record, List<List<String>> res) {
        if (i == n) {
            List<String> oneCase = new ArrayList<>();
            for (int k = 0; k < n; ++k) {
                StringBuilder line = new StringBuilder();
                int j = record[k];
                for (int l = 0; l < n; ++l) {
                    if (l == j) {
                        line.append("Q");
                    } else {
                        line.append(".");
                    }
                }
                oneCase.add(line.toString());
            }
            res.add(oneCase);
            return;
        }
        for (int j = 0; j < n; ++j) {
            if (isValid(i, j, record)) {
                record[i] = j;
                dfs(i + 1, n, record, res);
            }
        }
    }

    public boolean isValid(int i, int j, int[] record) {
        for (int k = 0; k < i; ++k) {
            if (record[k] == j || Math.abs(record[k] - j) == Math.abs(k - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(new NQueens().solveNQueens(n));
    }

}
