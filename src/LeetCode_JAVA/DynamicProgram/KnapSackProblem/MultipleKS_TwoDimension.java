package LeetCode_JAVA.DynamicProgram.KnapSackProblem;

import java.util.Scanner;

/**
 * 多重背包问题类似于0-1背包问题
 * 0-1背包问题是对每个物品选择0次或1次
 * 多重背包问题是对每个物品选择0次,1次,2次, ...,s次
 */
public class MultipleKS_TwoDimension {

    final int N = 110;
    int[] v = new int[N];
    int[] w = new int[N];
    int[] s = new int[N];
    int[][] f = new int[N][N];

    public static void main(String[] args) {
        new MultipleKS_TwoDimension().dp();
    }

    private void dp() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int V = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            s[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= V; j++) {
                // 多一层for循环 本质上是求f[i][j] = max(f[i - 1][j], f[i - 1][j - v] + w, ..., f[i - 1][j - s*v] + s*w)
                for (int k = 0; k <= s[i]; k++) { // 对于0-1背包实际上就是for循环的终止条件为k <= 1
                    if (k * v[i] <= j){
                        f[i][j] = Math.max(f[i][j], f[i - 1][j - k * v[i]] + k * w[i]);
                    }
                }
            }
        }
        System.out.println(f[n][V]);
    }

}
