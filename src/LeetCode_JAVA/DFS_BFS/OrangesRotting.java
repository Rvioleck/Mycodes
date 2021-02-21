package LeetCode_JAVA.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting {
    private int day = -1;

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean haveFresh = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1 && !haveFresh){
                    haveFresh = true;
                }
            }
        }
        if (!haveFresh){
            return 0;
        }
        while (!queue.isEmpty()){
            int curSize = queue.size();
            day++;
            while (curSize-- != 0){
                int[] point = queue.remove();
                int i = point[0], j = point[1];
                if (i - 1 >= 0 && grid[i - 1][j] == 1){
                    grid[i - 1][j] = 2;
                    queue.offer(new int[]{i - 1, j});
                }
                if (i + 1 < m && grid[i + 1][j] == 1){
                    grid[i + 1][j] = 2;
                    queue.offer(new int[]{i + 1, j});
                }
                if (j - 1 >= 0 && grid[i][j - 1] == 1){
                    grid[i][j - 1] = 2;
                    queue.offer(new int[]{i, j - 1});
                }
                if (j + 1 < n && grid[i][j + 1] == 1){
                    grid[i][j + 1] = 2;
                    queue.offer(new int[]{i, j + 1});
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return day;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
//                {2, 1, 1},
//                {1, 1, 0},
//                {0, 1, 1}
                {2, 0, 2},
                {2, 0, 2},
                {2, 1, 2}
        };
        System.out.println(new OrangesRotting().orangesRotting(grid));
    }

}
