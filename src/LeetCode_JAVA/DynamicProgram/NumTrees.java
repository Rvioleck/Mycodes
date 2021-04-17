package LeetCode_JAVA.DynamicProgram;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 二叉搜索树有多少种的问题可以转换为结点为n的二叉树有多少种形状
 * 其转移方程为f(n)=f(n-1)*f(0) + f(n-2)*f(1) +  ... +f(1)*f(n-2) + f(0)*f(n-1)
 * 形如上述递归方程的式子被称为卡特兰数
 * 当f(0)=1时，其递推结果为f(n) = (2n)! / n!*(n+1)!
 * f(n + 1) = 2 * (2 * n + 1) * f(n) / (n + 2)
 */
public class NumTrees {

    public int numTrees(int n) {
        long res = 1;
        for (int i = 1; i < n; i++) {
            res = 2 * (2L * i + 1) * res / (i + 2);
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new NumTrees().numTrees(4));
    }
}
