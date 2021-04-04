package LeetCode_JAVA.DynamicProgram.KnapSackProblem.Zero_OneKnapSack;

import java.util.Scanner;

/**
 * f[i][j]表示选择下标0~i的物品，背包容量为j时可以容纳的最大价值
 */
public class Zero_OneKS {

    final int N = 1010;
    int[] f = new int[N];

    private void dp(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int V = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            for (int j = V; j >= 0; j--) {
                if (j >= v){
                    f[j] = Math.max(f[j], f[j - v] + w);
                }
            }
        }
        System.out.println(f[V]);
    }

    public static void main(String[] args) {
        new Zero_OneKS().dp();
    }

}
