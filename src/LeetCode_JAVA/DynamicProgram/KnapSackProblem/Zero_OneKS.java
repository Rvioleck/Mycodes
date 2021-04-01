package LeetCode_JAVA.DynamicProgram.KnapSackProblem;

import java.util.Scanner;

public class Zero_OneKS {

    final int N = 1010;

    public static void main(String[] args) {
        new Zero_OneKS().dp();
    }

    private void dp() { // dp
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[N];
        int[] w = new int[N];
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        int[] f = new int[N];
        // f(i, j)状态集合: 所有只考虑前i个物品，且总体积不超过j的所有方案的集合
        for (int i = 1; i <= n; i++) {
/*          （1）对于二维的情况下，对于背包容量进行顺序还是倒序都可以，因为状态转移方程可以对于第i轮，其只依赖于第i-1层的j，所以对当前层j而言并不存在顺序差别，仅起遍历作用
            （3）为什么一维情况下枚举背包容量需要逆序？在二维情况下，状态f[i][j]是由上一轮i - 1的状态得来的，f[i][j]与f[i - 1][j]是独立的。
             而优化到一维后，如果我们还是正序，则有f[较小体积]更新到f[较大体积]，则有可能本应该用第i-1轮的状态却用的是第i轮的状态。
            （4）例如，一维状态第i轮对体积为3的物品进行决策，则f[7]由f[4]更新而来，
             这里的f[4]正确应该是f[i - 1][4]，但从小到大枚举j这里的f[4]在第i轮计算却变成了f[i][4]。
             当逆序枚举背包容量j时，我们求f[7]同样由f[4]更新，但由于是逆序，这里的f[4]还没有在第i轮计算，所以此时实际计算的f[4]仍然是f[i - 1][4]。*/
            for (int j = V; j >= 0; j--) {
                if (j >= v[i]) {
                    f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
                }
            }
        }
        System.out.println(f[V]);
    }
}
