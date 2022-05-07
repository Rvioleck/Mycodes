package DataStructure_zcy.dfs_dp;

public class Bob {

    public String bob(int N, int M, int i, int j, int k){
        long all = (long) Math.pow(4, k);
        long live = dfs(N, M, i, j, k);
        long gcd = gcd(all, live);
        return String.valueOf((live/gcd) + "/" + (all/gcd));
    }

    public long dfs(int N, int M, int row, int col, int rest){
        if (row < 0 || row == N || col < 0 || col == M){
            return 0;
        }
        if (rest == 0){
            return 1;
        }
        long live = dfs(N, M, row + 1, col, rest - 1);
        live += dfs(N, M, row - 1, col, rest - 1);
        live += dfs(N, M, row, col + 1, rest - 1);
        live += dfs(N, M, row, col - 1, rest - 1);
        return live;
    }

    public long gcd(long m, long n){
        return n == 0 ? m : gcd(n, m % n);
    }

}
