package LeetCode_JAVA.DynamicProgram;

/**
 * dp[i][j]表示坐标(1,1)到(i,j)的路径个数
 * 使dp[i][j]从dp[1][1]而非dp[0][0]开始：
 * ①可以省略首轮初始化dp[1][j]和dp[i][1]在解集合中遍历的结果和初始化的结果相同
 * ②对应实际问题的下标，逻辑更通顺
 */
public class UniquePath {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }

    public int uniquePaths_optimize(int m, int n) {
        // 二维情况下的等价代换(滚动数组)
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) continue;
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(new UniquePath().uniquePaths(m, n));
        System.out.println(new UniquePath().uniquePaths_optimize(m, n));
    }
}
