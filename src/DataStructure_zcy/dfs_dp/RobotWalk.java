package DataStructure_zcy.dfs_dp;

import org.junit.Test;

public class RobotWalk {
    // leetcode 688

    /**
     * @param N 行走范围1~N
     * @param E 行走终点E
     * @param rest 剩余步数rest
     * @param cur 当前的位置cur
     * @return 从cur走到E的总路径数
     * 时间复杂度O(2^k)
     */
    public int dfs(int N, int E, int rest, int cur){
        if (rest == 0){
            return cur == E ? 1 : 0;
        }
        if (cur == 1){ // 当前位置是1，下一步只能是2
            return dfs(N, E, rest - 1, 2);
        }
        if (cur == N){ // 当前位置是N，下一步只能是N-1
            return dfs(N, E, rest - 1, N - 1);
        }
        return dfs(N, E, rest - 1, cur + 1) + dfs(N, E, rest - 1, cur - 1);
    }

    @Test
    public void dfs_test(){
        System.out.println(dfs(10, 4, 8, 2));
    }

    /**
     * @param N 行走范围1~N
     * @param E 行走终点E
     * @param rest 剩余步数rest
     * @param cur 当前的位置cur
     * @param dp 记忆化搜索数组
     * @return 从cur走到E的总路径数
     * 时间复杂度O(N*K)
     */
    public int dfs_dp(int N, int E, int rest, int cur, int[][] dp){
        if (dp[rest][cur] != -1){
            return dp[rest][cur];
        }
        if (rest == 0){
            dp[rest][cur] = cur == E ? 1 : 0;
        } else if (cur == 1){
            dp[rest][cur] = dfs_dp(N, E, rest - 1, 2, dp);
        } else if (cur == N){
            dp[rest][cur] = dfs_dp(N, E, rest - 1, N - 1, dp);
        } else {
            dp[rest][cur] = dfs_dp(N, E, rest - 1, cur + 1, dp) +
                    dfs_dp(N, E, rest - 1, cur - 1, dp);
        }
        return dp[rest][cur];
    }

    @Test
    public void dfs_dp_test(){
        int N = 5, E = 4, rest = 4;
        int[][] dp = new int[rest + 1][N + 1];
        for (int i = 0; i <= rest; ++i){
            for (int j = 0; j <= N; ++j){
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs_dp(N, E, rest, 2, dp));
    }

    /**
     * @param N 行走范围1~N
     * @param E 行走终点E
     * @param rest 剩余步数rest
     * @param cur 当前的位置cur
     * @return 从cur走到E的总路径数
     * 时间复杂度O(N*K)
     */
    public int dp(int N, int E, int rest, int cur){
        int[][] f = new int[rest + 1][N + 1];
        for (int i = 0; i <= N; ++i){
            f[0][i] = 0;
        }
        f[0][E] = 1;
        for (int i = 1; i <= rest; ++i){
            for (int j = 1; j <= N; ++j){
                if (j == 1){
                    f[i][1] = f[i - 1][2];
                } else if (j == N){
                    f[i][N] = f[i - 1][N - 1];
                } else {
                    f[i][j] = f[i - 1][j - 1] + f[i - 1][j + 1];
                }
            }
        }
        return f[rest][cur];
    }

    @Test
    public void dp_test(){
        System.out.println(dp(10, 4, 8, 2));
    }

}
