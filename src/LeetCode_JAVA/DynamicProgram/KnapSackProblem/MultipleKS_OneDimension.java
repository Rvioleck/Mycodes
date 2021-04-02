package LeetCode_JAVA.DynamicProgram.KnapSackProblem;

import java.util.Scanner;

/**
 * 同于0-1背包问题，完全背包问题的空间优化也是
 * 通过"滚动数组"这个技巧，对二维数组进行【等价变换】
 * 但是因为其为特殊的0-1背包问题，所以为了保证f[j]正常的进行更新
 * 也要对'j的循环'进行逆序，原因详见0-1背包的一维数组实现
 */
public class MultipleKS_OneDimension {

    final int N = 110;
    int[] v = new int[N];
    int[] w = new int[N];
    int[] s = new int[N];
    int[] f = new int[N];

    public static void main(String[] args) {
        new MultipleKS_OneDimension().dp();
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
            for (int j = V; j >= 0; j--) {
                for (int k = 0; k <= s[i]; k++) {
                    if (j >= k * v[i]){
                        f[j] = Math.max(f[j], f[j - k * v[i]] + k * w[i]);
                    }
                }
            }
        }
        System.out.println(f[V]);
    }
}
