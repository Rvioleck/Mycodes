package LeetCode_JAVA.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Solve {
    private int m, n;

    private void bfs(char[][] board, int x, int y, char ch) {
        board[x][y] = ch;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] point = queue.remove();
            int i = point[0], j = point[1];
            if (i - 1 >= 0 && board[i - 1][j] == 'O') {
                board[i - 1][j] = ch;
                queue.offer(new int[]{i - 1, j});
            }
            if (i + 1 < m && board[i + 1][j] == 'O') {
                board[i + 1][j] = ch;
                queue.offer(new int[]{i + 1, j});
            }
            if (j - 1 >= 0 && board[i][j - 1] == 'O') {
                board[i][j - 1] = ch;
                queue.offer(new int[]{i, j - 1});
            }
            if (j + 1 < n && board[i][j + 1] == 'O') {
                board[i][j + 1] = ch;
                queue.offer(new int[]{i, j + 1});
            }
        }
    }

    public void solve(char[][] board) {
        m = board.length;
        if (m == 0)
            return;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] != 'X') bfs(board, i, 0, 'A');
            if (board[i][n - 1] != 'X') bfs(board, i, n - 1, 'A');
        }
        for (int i = 1; i < n - 1; i++) {
            if (board[0][i] != 'X') bfs(board, 0, i, 'A');
            if (board[m - 1][i] != 'X') bfs(board, m - 1, i, 'A');
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    bfs(board, i, j, 'X');
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        new Solve().solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
