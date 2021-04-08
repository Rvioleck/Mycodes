package LeetCode_JAVA.DynamicProgram.KnapSackProblem.CompleteKnapSack;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3/
 * 完全背包问题在0-1背包其问题的基础上，可以选择多个相同的物品
 * 其区别仅为动态规划转移方程的不同
 * 
 * f[i][j] = max(f[i - 1][j], f[i - 1][j - v[i]] + w[i], ..., f[i - 1][j - k*v[i]] + k*w[i]) ①
 * f[i][j - v[i]] = max(f[i - 1][j - v[i]], f[i - 1][j - 2*v[i]] + w[i], ..., f[i - 1][j - k*v[i]] + (k-1)*w[i]) ②
 * 将②式带入①式可得: f[i][j] = max(f[i - 1][j], f[i][j - v[i]] + w[i])
 */


public class CompleteKS_TwoDimension {

    final int N = 1010;
    int[] v = new int[N];
    int[] w = new int[N];
    int[][] f = new int[N][N];

    public static void main(String[] args) {
        new CompleteKS_TwoDimension().dp();
    }

    private void dp() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int V = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= V; j++) {
                if (j - v[i] >= 0) {
                    // 本质上是从①不选物品i(选0个物品i)，②选一个物品i,...,③选k个物品i。中选择一个最大的方案
                    // 转移方程化简如下
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - v[i]] + w[i]);
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }
        }
        System.out.println(f[n][V]);
    }
}
