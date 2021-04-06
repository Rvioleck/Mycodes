package LeetCode_JAVA.DynamicProgram.KnapSackProblem.Zero_OneKnapSack;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/2/
 * 0-1背包问题，二维数组实现
 */
public class Zero_OneKS_TwoDimension {

    final int N = 1010;
    int[] v = new int[N];
    int[] w = new int[N];
    int[][] f = new int[N][N];

    public static void main(String[] args) {
        new Zero_OneKS_TwoDimension().dp();
    }

    private void dp() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int V = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        // f(i, j)状态集合: 所有只考虑前i个物品，且总体积不超过j的所有方案的集合
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= V; j++) {
                // (1)对于二维的情况下，对于背包容量进行顺序还是倒序都可以
                // 因为状态转移方程对于第i轮，其只依赖于第i-1层的j，所以对当前层j而言并不存在遍历的顺序差别，仅起遍历作用
                // (2)对于二维的情况下，先遍历物品还是先遍历背包容量都可以
                // 因为状态转移方程f[i][j]只依赖于f[i-1][j]和f[i][j-x]，所以对于f[i][j]而言，先从哪个反向来更新都一样
                if (j - v[i] >= 0) {     // f(i, j)解集合1: 当空间够放物品i时
                    f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - v[i]] + w[i]); // 结果为不放i和放i时更大的价值
                } else {                // f(i, j)解集合2: 当空间不够放物品i时
                    f[i][j] = f[i - 1][j]; // 结果为不放i时，即同i-1状态时的价值相同
                }
            }
        }
        System.out.println(f[n][V]); // 总结果为考虑n个物品，且总体积不超过V的所有方案的集合
    }
}
