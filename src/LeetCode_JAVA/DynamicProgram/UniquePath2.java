package LeetCode_JAVA.DynamicProgram;

/**
 * dp[i][j]表示坐标(1,1)到(i,j)的路径个数
 */
public class UniquePath2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = (obstacleGrid[0][0] == 0) ? 1 : 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
//                if (i == 1 && j == 1 || obstacleGrid[i - 1][j - 1] == 1) continue;
                // 化成上述if简化了逻辑，则在等价压缩的时候会出问题
                // 所以若要进行等价压缩，需要使用下述的if-else
                if (i == 1 && j == 1) continue; // 初始结点已经被初始化，跳过
                if (obstacleGrid[i - 1][j - 1] == 1){
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public int uniquePathsWithObstacles_optimise(int[][] obstacleGrid){
        // 二维数组的等价代换(滚动数组)
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n + 1];
        dp[1] = (obstacleGrid[0][0] == 0) ? 1 : 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) continue;
                if (obstacleGrid[i - 1][j - 1] == 1){
                    dp[j] = 0;
                } else {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.println(new UniquePath2().uniquePathsWithObstacles(grid));
        System.out.println(new UniquePath2().uniquePathsWithObstacles_optimise(grid));
    }

}
