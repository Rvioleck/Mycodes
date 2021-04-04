package LeetCode_JAVA.DynamicProgram.KnapSackProblem.Zero_OneKnapSack;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/8/
 * 二维费用的0-1背包问题
 */
public class Zero_OneKS_TwoCosts {

    public static void main(String[] args) {
        new Zero_OneKS_TwoCosts().dp();
    }

    private void dp(){
        final int N = 1010;
        int[][] dp = new int[N][N];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int V = sc.nextInt();
        int M = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int v = sc.nextInt(), m = sc.nextInt(), w = sc.nextInt();
            for (int j = V; j >= v; j--) {
                for (int k = M; k >= m; k--) { // 相较一维费用的背包问题仅多了一个枚举重量的循环
                    dp[j][k] = Math.max(dp[j][k], dp[j - v][k - m] + w);
                }
            }
        }
        System.out.println(dp[V][M]);
    }
}
