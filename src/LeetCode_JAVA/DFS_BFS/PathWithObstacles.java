package LeetCode_JAVA.DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/robot-in-a-grid-lcci/
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。
 * 设计一种算法，寻找机器人从左上角移动到右下角的路径。
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。
 */
public class PathWithObstacles {

    int m, n;

    private boolean dfs(List<List<Integer>> path, int[][] obstacleGrid, int x, int y) {
        if (x == m - 1 && y == n - 1) {
            return true; // 找到一个可行结果之后直接链式返回
        }
        if (x + 1 < m && obstacleGrid[x + 1][y] == 0) {
            path.add(new ArrayList<>(Arrays.asList(x + 1, y)));
            if (dfs(path, obstacleGrid, x + 1, y)) return true; // 找到一个可行结果直接链式返回
            path.remove(path.size() - 1);
        }
        if (y + 1 < n && obstacleGrid[x][y + 1] == 0) {
            path.add(new ArrayList<>(Arrays.asList(x, y + 1)));
            if (dfs(path, obstacleGrid, x, y + 1)) return true; // 找到一个可行结果直接链式返回
            path.remove(path.size() - 1);
        }
        obstacleGrid[x][y] = 1; // 记录过但走不通的路径置为1
        return false;  // 无可行路径返回false
    }

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> path = new ArrayList<>();
        path.add(new ArrayList<>(Arrays.asList(0, 0))); // 假设初始点不会有障碍物
        this.m = obstacleGrid.length;
        this.n = obstacleGrid[0].length;
        // 初始点有障碍物直接结束
        return obstacleGrid[0][0] != 1 && dfs(path, obstacleGrid, 0, 0) ? path : new ArrayList<>();
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0}
        };
        System.out.println(new PathWithObstacles().pathWithObstacles(grid));
    }

}
