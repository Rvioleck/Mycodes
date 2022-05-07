package DataStructure_zcy.dfs_dp;

public class CoinsWays {

    public int dfs(int[] arr, int index, int rest){
        if (index == arr.length){
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int i = 0; i * arr[index] <= rest; i++) {
            ways += dfs(arr, index + 1, rest - i * arr[index]);
        }
        return ways;
    }

    public int dp(int[] arr, int aim){
        int N = arr.length;
        int[][] f = new int[N + 1][aim + 1];
        f[N][0] = 1;
        for (int i = N - 1; i >= 0; --i){
            for (int j = 0; j <= aim; ++j){
                int ways = 0;
                for (int k = 0; k * arr[i] <= j; k ++){
                    ways += f[i + 1][j - k * arr[i]];
                }
                // f[i][j] = f[i+1][j] + f[i+1][j-arr[i]] + f[i+1][j-2*arr[i]] +...
                f[i][j] = ways;
            }
        }
        return f[0][aim];
    }

}
