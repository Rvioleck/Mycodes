package LeetCode_JAVA.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDistance {
    private int m, n;
    private int max = -1;

    private int bfs(int[][] grid, int x, int y) {
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0});
        while (!queue.isEmpty()) {
            int[] point = queue.remove();
            int i = point[0], j = point[1], dis = point[2];
            if (i < 0 || i >= m || j < 0 || j >= n) continue;
            if (vis[i][j] == true) continue;
            if (grid[i][j] == 1) {
                return dis;
            }
            vis[i][j] = true;
            queue.offer(new int[]{i + 1, j, dis + 1});
            queue.offer(new int[]{i - 1, j, dis + 1});
            queue.offer(new int[]{i, j + 1, dis + 1});
            queue.offer(new int[]{i, j - 1, dis + 1});
        }
        return -1;
    }

    public int maxDistance(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    max = Math.max(max, bfs(grid, i, j));
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        System.out.println(new MaxDistance().maxDistance(grid));
    }

}