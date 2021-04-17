package LeetCode_JAVA.DFS_BFS;

public class Exist {
/*
 private String word;
 private int m, n;
 private boolean res = false;
 private boolean[][] vis;

 private void dfs(char[][] board, StringBuffer letters, int x, int y, int index) {
     if (new String(letters).equals(word)) {
         res = true;
         return;
     }
     if (res) return;
     if (x < 0 || x >= m || y < 0 || y >= n) return;
     if (board[x][y] != word.charAt(index)) return;
     if (vis[x][y]) return;

     vis[x][y] = true;
     letters.append(board[x][y]);

     dfs(board, letters, x + 1, y, index + 1);

     dfs(board, letters, x, y + 1, index + 1);

     dfs(board, letters, x - 1, y, index + 1);

     dfs(board, letters, x, y - 1, index + 1);

     vis[x][y] = false;
     letters.deleteCharAt(letters.length() - 1);
 }


 public boolean exist(char[][] board, String word) {
     this.word = word;
     StringBuffer letters = new StringBuffer();
     this.m = board.length;
     this.n = board[0].length;
     vis = new boolean[m][n];
     for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
             if (!res)
                 dfs(board, letters, i, j, 0);
         }
     }
     return res;
 }
*/

    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    String word;
    int strLen;

    public boolean dfs(char[][] board, int x, int y, int m, int n, int len) {
        if (x < 0 || x >= m || y < 0 || y >= n || len >= strLen || board[x][y] != word.charAt(len)) {
            return false;
        }
        if (len == strLen - 1) {
            return true;
        }
        for (int i = 0; i <= 3; i++) {
            char temp = board[x][y];
            board[x][y] = '#';
            boolean res = dfs(board, x + dir[i][0], y + dir[i][1], m, n, len + 1);
            if (res) return true;
            board[x][y] = temp;
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        this.word = word;
        this.strLen = word.length();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean res = dfs(board, i, j, m, n, 0);
                if (res) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /// 必须用二维数组标记是否使用过
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(new Exist().exist(new char[][]{{'a'}}, "ab"));
    }

}
