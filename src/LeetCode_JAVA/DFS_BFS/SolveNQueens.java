package LeetCode_JAVA.DFS_BFS;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens {

    int[][] dxdy = new int[][]{
            {0, 1}, {0, -1}, {1, 1}, {1, -1}, {1, 0}, {-1, 0}, {-1, 1}, {-1, -1}
    };

    public List<List<String>> solveNQueens(int n) {
        boolean[][] attack = new boolean[n][n];
        List<List<String>> res = new ArrayList<>();
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        backtrace(0, n, attack, res, chess);
        return res;
    }

    private void putQueen(int x, int y, int n, boolean[][] attack){
        for (int i = 0; i < 8; i++) {
            int dx = x;
            int dy = y;
            for (int j = 0; j < n; j++) {
                if (dx < n && dx >= 0 && dy < n && dy >= 0){
                    attack[dx][dy] = true;
                }
                dx += dxdy[i][0];
                dy += dxdy[i][1];
            }
        }
    }

    private void backtrace(int k, int n, boolean[][] attack, List<List<String>> res, char[][] chess) {
        if (k == n){
            List<String> oneSolve = generateBoard(chess, n);
            res.add(new ArrayList<>(oneSolve));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (attack[k][i]) continue;
            chess[k][i] = 'Q';
            boolean[][] temp = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                temp[j] = attack[j].clone();
            }
            putQueen(k, i, n, attack);
            backtrace(k + 1, n, attack, res, chess);
            chess[k][i] = '.';
            attack = temp;
        }
    }

    private List<String> generateBoard(char[][] chess, int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(String.valueOf(chess[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        SolveNQueens obj = new SolveNQueens();
        System.out.println(obj.solveNQueens(8));
    }

}
