package LeetCode_JAVA.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * TLE
 *
 */
public class MaxValue_BFS {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new MaxValue_BFS().maxValue(grid));
    }

    public int maxValue(int[][] grid) {
        int max = 0;
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, grid[0][0]});
        while (!queue.isEmpty()){
            int[] point = queue.poll();
            int x = point[0], y = point[1], val = point[2];
            if (x == m - 1 && y == n - 1){
                max = Math.max(max, val);
            }
            if (x + 1 < m){
                queue.offer(new int[]{x + 1, y, val + grid[x + 1][y]});
            }
            if (y + 1 < n){
                queue.offer(new int[]{x, y + 1, val + grid[x][y + 1]});
            }
        }
        return max;
    }

}
