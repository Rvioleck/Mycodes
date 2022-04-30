package LeetCode_JAVA.DFS_BFS.N_Queens;

public class NQueens2 {

    /*
     * https://leetcode-cn.com/problems/n-queens-ii/
     * */
    public int totalNQueens(int n) {
        int[] record = new int[n];
        return dfs(0, n, record);
    }

    public int dfs(int i, int n, int[] record) {
        if (i == n) return 1;
        int res = 0;
        for (int j = 0; j < n; ++j) {
            if (valid(record, i, j)) {
                record[i] = j;
                res += dfs(i + 1, n, record);
            }
        }
        return res;
    }

    public boolean valid(int[] record, int i, int j) {
        for (int k = 0; k <= i - 1; ++k) {
            if (record[k] == j || Math.abs(record[k] - j) == Math.abs(k - i)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int n = 8;
        System.out.println(new NQueens2().totalNQueens(n));
    }
}
