package DataStructure_zcy.dfs_dp;

import org.junit.Test;

public class MinCoins {

    public int dfs(int[] arr, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (rest == 0) {
            return 0;
        }
        if (index == arr.length) {
            return -1;
        }
        int without = dfs(arr, index + 1, rest);
        int with = dfs(arr, index + 1, rest - arr[index]);
        if (without == -1 && with == -1) {
            return -1;
        } else if (without == -1) {
            return 1 + with;
        } else if (with == -1){
            return without;
        } else {
            return Math.min(with + 1, without);
        }
    }

    @Test
    public void dfs_test(){
        System.out.println(dfs(new int[]{2, 3, 8, 5}, 0, 10));
    }

    public int dfs_dp(int[] arr, int index, int rest, int[][] dp){
        if (rest < 0){
            return -1;
        }
        if (dp[index][rest] != -2){
            return dp[index][rest];
        }
        if (rest == 0){
            dp[index][rest] = 0;
        } else if (index == arr.length){
            dp[index][rest] = -1;
        } else {
            int without = dfs_dp(arr, index + 1, rest, dp);
            int with = dfs_dp(arr, index + 1, rest - arr[index], dp);
            if (without == -1 && with == -1){
                dp[index][rest] = -1;
            } else if (without == -1){
                dp[index][rest] = 1 + with;
            } else if (with == -1){
                dp[index][rest] = without;
            } else {
                dp[index][rest] = Math.min(with + 1, without);
            }
        }
        return dp[index][rest];
    }

    @Test
    public void dfs_dp_test(){
        int[] arr = new int[]{2, 3, 8, 5};
        int aim = 10;
        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int i = 0; i <= arr.length; ++i){
            for (int j = 0; j <= aim; ++j){
                dp[i][j] = -2;
            }
        }
        System.out.println(dfs_dp(arr, 0, aim, dp));
    }

    public int dp(int[] arr, int aim){
        int N = arr.length;
        int[][] f = new int[N + 1][aim + 1];
        for (int i = 0; i <= N; ++i){
            f[i][0] = 0;
        }
        for (int j = 1; j <= aim; ++j){
            f[N][j] = -1;
        }
        for (int i = N - 1; i >= 0; --i){
            for (int j = 1; j <= aim; ++j){
                int without = f[i + 1][j];
                int with = j - arr[i] >= 0 ? f[i + 1][j - arr[i]] : -1;
                if (with == -1 && without == -1){
                    f[i][j] = -1;
                } else if (without == -1){
                    f[i][j] = with + 1;
                } else if (with == -1){
                    f[i][j] = without;
                } else {
                    f[i][j] = Math.min(without, with + 1);
                }
            }
        }
        return f[0][aim];
    }

    @Test
    public void dp_test(){
        System.out.println(dp(new int[]{2, 3, 8, 5}, 10));
    }

}
