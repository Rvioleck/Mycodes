package LeetCode_JAVA.DFS_BFS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/
 */
public class SolveNQueens2 {
    List<List<String>> solve = new ArrayList<>();
    List<String> one = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new SolveNQueens2().solveNQueens(4));
    }

    private void dfs(int index, char[][] chess) {
        if (index == chess.length) {
            one = generateBoard(chess);
            solve.add(new ArrayList<>(one));
            return;
        }
        for (int i = 0; i < chess.length; i++) {
            if (!isValid(index, i, chess)) continue;
            chess[index][i] = 'Q';
            dfs(index + 1, chess);
            chess[index][i] = '.';
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(chess[i], '.');
        }
        dfs(0, chess);
        return solve;
    }

    private List<String> generateBoard(char[][] chess) {
        List<String> one = new ArrayList<>();
        for (char[] line : chess) {
            one.add(String.valueOf(line));
        }
        return one;
    }

    private boolean isValid(int x, int y, char[][] chess) {
        int[][] direct = new int[][]{{-1, 1}, {-1, 0}, {-1, -1}}; // ↖ ↑ ↗
        for (int i = 1; i < chess.length; i++) {
            for (int[] d : direct) {
                int dx = x + i * d[0], dy = y + i * d[1];
                if (dx < chess.length && dx >= 0 && dy < chess.length && dy >= 0 && chess[dx][dy] == 'Q') {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void isValidTest() {
        char[][] chess = {
                {'Q', '.', '.', '.'},
                {'.', '.', 'Q', '.'},
                {'.', 'Q', '.', '.'},
                {'.', '.', '.', 'Q'}
        };
        boolean res = isValid(2, 1, chess);
        System.out.println(res);
    }
}
