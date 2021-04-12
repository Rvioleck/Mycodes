package LeetCode_JAVA.DFS_BFS;

public class IslandPerimeter {

    private boolean[][] visit;
    private int m, n;
    int count = 0;

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        this.m = m;
        this.n = n;
        visit = new boolean[m][n];
        boolean tag = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (satisfy(grid, i, j) && !tag) {
                    visit[i][j] = true;
                    dfs(grid, i, j);
                    tag = true;
                }
            }
        }
        return count;
    }

    private boolean satisfy(int[][] grid, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1 && !visit[x][y];
    }

    private void dfs(int[][] grid, int x, int y) {
        count += 4;
        if (satisfy(grid, x + 1, y)) {
            visit[x + 1][y] = true;
            count -= 2;
            dfs(grid, x + 1, y);
        }
        if (satisfy(grid, x - 1, y)) {
            visit[x - 1][y] = true;
            count -= 2;
            dfs(grid, x - 1, y);
        }
        if (satisfy(grid, x, y - 1)) {
            visit[x][y - 1] = true;
            count -= 2;
            dfs(grid, x, y - 1);
        }
        if (satisfy(grid, x, y + 1)) {
            visit[x][y + 1] = true;
            count -= 2;
            dfs(grid, x, y + 1);
        }
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
        System.out.println(new IslandPerimeter().islandPerimeter(grid));
    }

}
