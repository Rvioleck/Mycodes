package DataStructure_zcy.dfs_dp;

import org.junit.Test;

public class HorseJump {

    public int dfs(int x, int y, int step){
        // return 从(0, 0)->(x, y) step步的次数
        if (x < 0 || x > 8 || y < 0 || y > 9){
            return 0;
        }
        if (step == 0){
            return (x == 0 && y == 0) ? 1 : 0;
        }
        return dfs(x - 1, y + 2, step - 1) +
                dfs(x + 1, y + 2, step - 1) +
                dfs(x + 2, y + 1, step - 1) +
                dfs(x - 2, y + 1, step - 1) +
                dfs(x - 1, y - 2, step - 1) +
                dfs(x + 1, y - 2, step - 1) +
                dfs(x + 2, y - 1, step - 1) +
                dfs(x - 2, y - 1, step + 1);
    }

    public int dp(int x, int y, int step){
        int[][][] f = new int[9][10][step + 1];
        f[0][0][0] = 1;
        for (int k = 1; k <= step; ++k){
            for (int i = 0; i <= 8; ++i){
                for (int j = 0; j <= 9; ++j){
                    f[i][j][k] += getValue(f, i - 1, j + 2, k - 1);
                    f[i][j][k] += getValue(f, i + 1, j + 2, k - 1);
                    f[i][j][k] += getValue(f, i - 1, j - 2, k - 1);
                    f[i][j][k] += getValue(f, i + 1, j - 2, k - 1);
                    f[i][j][k] += getValue(f, i + 2, j + 1, k - 1);
                    f[i][j][k] += getValue(f, i - 2, j + 1, k - 1);
                    f[i][j][k] += getValue(f, i + 2, j - 1, k - 1);
                    f[i][j][k] += getValue(f, i - 2, j - 1, k - 1);
                }
            }
        }
        return f[x][y][step];
    }

    public int getValue(int[][][] f, int i, int j, int k){
        if (i < 0 || i > 8 || j < 0 || j > 9 || k < 0){
            return 0;
        }
        return f[i][j][k];
    }

    public static void main(String[] args) {
        System.out.println(new HorseJump().dfs(1, 2, 1));
        System.out.println(new HorseJump().dp(7, 7, 10));
    }


}
