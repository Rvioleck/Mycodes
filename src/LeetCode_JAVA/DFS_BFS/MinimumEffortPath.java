package LeetCode_JAVA.DFS_BFS;

public class MinimumEffortPath {

    public static void main(String[] args) {
        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(new MinimumEffortPath().minimumEffortPath(heights));
    }

    int minCost = Integer.MAX_VALUE;
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public void dfs(int[][] heights, int x, int y, int curMinCost, int preCost, boolean[][] vis){
        if (x < 0 || x >= heights.length || y < 0 || y >= heights[0].length){
            return;
        }
        int deltaCost = Math.abs(heights[x][y] - preCost);
        curMinCost = Math.max(curMinCost, deltaCost);
        if (curMinCost > minCost) return;
        if (x == heights.length - 1 && y == heights[0].length - 1){
            minCost = curMinCost;
            return;
        }
        for (int i = 0; i <= 3; ++i){
            if (vis[x][y]) continue;
            vis[x][y] = true;
            dfs(heights, x + dir[i][0], y + dir[i][1], curMinCost, heights[x][y], vis);
            vis[x][y] = false;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        boolean[][] vis = new boolean[heights.length][heights[0].length];
        dfs(heights, 0, 0, 0, heights[0][0], vis);
        return minCost;
    }

}
