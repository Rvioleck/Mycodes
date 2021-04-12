package LeetCode_JAVA.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class IslandPerimeter2 {

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }
    }

    boolean[][] vis;

    public int islandPerimeter(int[][] grid) {
        int[][] delta = new int[][]{
                {1, -1, 0, 0},
                {0, 0, 1, -1}
        };
        int m = grid.length;
        int n = grid[0].length;
        vis = new boolean[m][n];
        int i = 0, j = 0;
        outer:
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    break outer;
                }
            }
        }
        int count = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            count += 4;
            int x = point.x, y = point.y;
            for (int k = 0; k < 4; k++) {
                i = x + delta[0][k];
                j = y + delta[1][k];
                if (satisfy(grid, i, j)) {
                    count -= 2;
                    point = new Point(i, j);
                    if (!queue.contains(point)) {
                        queue.add(point);
                    }
                }
            }
            vis[x][y] = true;
        }
        return count;
    }

    private boolean satisfy(int[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        return x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && grid[x][y] == 1;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 1},
                {1, 1}
//                {0,1,0,0},
//                {1,1,1,0},
//                {0,1,0,0},
//                {1,1,0,0}
        };
        System.out.println(new IslandPerimeter2().islandPerimeter(grid));
    }

}
