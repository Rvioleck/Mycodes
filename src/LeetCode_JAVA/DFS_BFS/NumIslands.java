package LeetCode_JAVA.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {
    int m, n;
    int count = 0;

    private void dfs(char[][] grid, int x, int y){
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != '1')
            return;
        grid[x][y] = '0';
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }

    private void bfs(char[][] grid, int x, int y){
        grid[x][y] = '0';
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()){
            int[] point = queue.remove();
            int i = point[0], j = point[1];
            if (i + 1 < m && grid[i + 1][j] == '1'){
                queue.offer(new int[]{i + 1, j});
                grid[i + 1][j] = '0';
            }
            if (i - 1 >= 0 && grid[i - 1][j] == '1'){
                queue.offer(new int[]{i - 1, j});
                grid[i - 1][j] = '0';
            }
            if (j + 1 < n && grid[i][j + 1] == '1'){
                queue.offer(new int[]{i, j + 1});
                grid[i][j + 1] = '0';
            }
            if (j - 1 >= 0 && grid[i][j - 1] == '1'){
                queue.offer(new int[]{i, j - 1});
                grid[i][j - 1] = '0';
            }
        }
    }

    public int numIslands2(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1'){
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(new NumIslands().numIslands2(grid));
    }
}
