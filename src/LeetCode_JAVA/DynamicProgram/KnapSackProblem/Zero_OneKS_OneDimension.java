package LeetCode_JAVA.DynamicProgram.KnapSackProblem;

import java.util.Scanner;

/**
 * 对使用二维数组的0-1背包问题优化到使用一维数组的0-1背包问题
 * 本质上思想没有改变，仍为所有物品的遍历与所有体积的遍历
 * 但是其可以通过"滚动数组"这个技巧，对二维数组进行【等价变换】
 * 将其转化为一维数组并使其空间复杂度更小
 */
public class Zero_OneKS_OneDimension {

    final int N = 1010;
    int[] v = new int[N];
    int[] w = new int[N];
    int[] f = new int[N];

    public static void main(String[] args) {
        new Zero_OneKS_OneDimension().dp();
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
/*          （2）为什么一维情况下枚举背包容量需要逆序？在二维情况下，状态f[i][j]是由上一轮i - 1的状态得来的，f[i][j]与f[i - 1][j]是独立的。
             而优化到一维后，如果我们还是正序，则有f[较小体积]更新到f[较大体积]，则有可能本应该用第i-1轮的状态却用的是第i轮的状态。
            （3）例如，一维状态第i轮对体积为3的物品进行决策，则f[7]由f[4]更新而来，
             这里的f[4]正确应该是f[i - 1][4]，但从小到大枚举j这里的f[4]在第i轮f[7]计算之前却变成了f[i][4]。
             当逆序枚举背包容量j时，我们求f[7]同样由f[4]更新，但由于是逆序，这里的f[4]还没有在第i轮计算，所以此时实际计算的f[4]仍然是f[i - 1][4]。*/
            for (int j = V; j >= 0; j--) {
                if (j - v[i] >= 0) {
                    // 原式 = f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - v[i]] + w[i])
                    f[j] = Math.max(f[j], f[j - v[i]] + w[i]); // f[j - v[i]]为第i-1层
                    // 上式 ↔ f[i][j] = Math.max(f[i - 1][j], f[i][j - v[i]] + w[i])
                    // 但此时不等价于原式，将内层'j的循环'逆序之后，上述三个式子等价
                }
                // 原本的else中的原式f[i][j] = f[i - 1][j] ↔ f[j] = f[j]
                // 此处由于f[j]的更新是由外层'i的循环'决定的，而将其降维度之后仍然是等价的
                // (在逻辑层面将i-1层的f[j]赋值给i层的f[j]，其含义没有改变)
                // (在代码层面而等价变换之后的代码f[j] = f[j]为恒等式可以直接去掉其和else语句)
            }
        }
        System.out.println(f[V]);
    }
}
