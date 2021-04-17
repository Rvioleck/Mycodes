package LeetCode_JAVA.DFS_BFS;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sudoku-solver/
 * 编写一个程序，通过填充空格来解决9x9数独问题。
 */
public class SolveSudoku {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new SolveSudoku().solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

    public void solveSudoku(char[][] board) {
        dfs(board);
    }

    private boolean dfs(char[][] board) {
        for (int i = 0; i < board.length; i++) {        // 枚举行
            for (int j = 0; j < board[i].length; j++) { // 枚举列
                if (board[i][j] != '.') continue;
                for (char k = '1'; k <= '9'; k++) {     // 枚举可以放入的数字
                    if (!isValid(i, j, k, board)) continue;
                    board[i][j] = k;
                    if (dfs(board)) return true; // 如果找到合适一组立刻返回(级联返回)
                    board[i][j] = '.';
                }
                return false;  // 九个数均不成立，无解直接返回
            }
        }
        return true; // 没有返回，肯定有解
    }

    private boolean isValid(int x, int y, char val, char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == val || board[x][i] == val) {
                return false;
            }
        }
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
