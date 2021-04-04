package LeetCode_JAVA.DynamicProgram.KnapSackProblem;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3/
 * 同于0-1背包问题，完全背包问题的空间优化也是
 * 通过"滚动数组"这个技巧，对二维数组进行【等价变换】
 */
public class CompleteKS_OneDimension {
    final int N = 1010;
    int[] v = new int[N];
    int[] w = new int[N];
    int[] f = new int[N];

    public static void main(String[] args) {
        new CompleteKS_OneDimension().dp();
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
                if (j >= v[i]){
                    f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
                } else {
                    f[j] = f[j];
                }
            }
        }
        System.out.println(f[V]);
    }
}
