package LeetCode_JAVA.DynamicProgram.PrefixSum;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 */
public class MaxSumSubmatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5 , -4, -3,  4},
                {-3, -4,  4,  5},
                {5 ,  1,  5, -4}
        };
        System.out.println(new MaxSumSubmatrix().maxSumSubmatrix(matrix, 10));
        System.out.println(new MaxSumSubmatrix().maxSumSubmatrix1(matrix, 10));
        System.out.println(new MaxSumSubmatrix().maxSumSubmatrix2(matrix, 10));
        System.out.println(new MaxSumSubmatrix().maxSumSubmatrix3(matrix, 10));
    }

    /**
     * @param matrix 原m×n矩阵
     * @param k 约束数值k
     * @return 不超过k的最大区域和
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int p = i; p <= m; p++) {
                    for (int q = j; q <= n; q++) {
                        int cur = prefix[p][q] - prefix[i - 1][q] - prefix[p][j - 1] + prefix[i - 1][j - 1];
                        if (cur <= k) {
                            ans = Math.max(ans, cur);
                        }
                    }
                }
            }
        }
        return ans;
    }

    public int maxSumSubmatrix1(int[][] matrix, int k){
        // 通过TreeSet的二分属性，优化左边界的查找
        int m = matrix.length, n = matrix[0].length;
        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int ans = Integer.MIN_VALUE;
        // 遍历子矩阵的上边界
        for (int top = 1; top <= m; top++) {
            // 遍历子矩阵的下边界
            for (int bot = top; bot <= m; bot++) {
                // 使用「有序集合」维护所有遍历到的右边界
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                // 遍历子矩阵的右边界
                for (int r = 1; r <= n; r++) {
                    // 通过前缀和计算 right
                    int right = prefix[bot][r] - prefix[top - 1][r];
                    // 通过二分找 left
                    Integer left = ts.ceiling(right - k);
                    // ceiling取出left >= right - k
                    if (left != null) {
                        // ans = right - left <= k 满足要求
                        int cur = right - left;
                        ans = Math.max(ans, cur);
                    }
                    // 将遍历过的 right 加到有序集合
                    ts.add(right);
                }
            }
        }
        return ans;
    }

    public int maxSumSubmatrix2(int[][] matrix, int k){
        // 通过选择更小的行/列的值，使二分效率更大
        int m = matrix.length, n = matrix[0].length;
        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        boolean isRight = m > n; // 选择更小的用set进行优化
        int ans = Integer.MIN_VALUE;
        // 遍历子矩阵的上边界
        for (int i = 1; i <= (isRight ? n : m); i++) {
            for (int j = i; j <= (isRight ? n : m); j++) {
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                for (int fixed = 1; fixed <= (isRight ? m : n); fixed++) {
                    int a = isRight ? prefix[fixed][j] - prefix[fixed][i - 1] : prefix[j][fixed] - prefix[i - 1][fixed];
                    Integer left = ts.ceiling(a - k);
                    if (left != null) {
                        int cur = a - left;
                        ans = Math.max(ans, cur);
                    }
                    ts.add(a);
                }
            }
        }
        return ans;
    }

    public int maxSumSubmatrix3(int[][] matrix, int k){
        // 通过选择更小的行/列的值，使二分效率更大
        int m = matrix.length, n = matrix[0].length;
        boolean isRight = m > n; // 选择更小的用set进行优化
        int[] prefix = isRight ? new int[m + 1] : new int[n + 1];
        int ans = Integer.MIN_VALUE;
        // 遍历子矩阵的上边界
        for (int i = 1; i <= (isRight ? n : m); i++) {
            Arrays.fill(prefix, 0);
            for (int j = i; j <= (isRight ? n : m); j++) {
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                int a = 0;
                for (int fixed = 1; fixed <= (isRight ? m : n); fixed++) {
                    prefix[fixed] += isRight ? matrix[fixed - 1][j - 1] : matrix[j - 1][fixed - 1];
                    a += prefix[fixed];
                    Integer left = ts.ceiling(a - k);
                    if (left != null) {
                        int cur = a - left;
                        ans = Math.max(ans, cur);
                    }
                    ts.add(a);
                }
            }
        }
        return ans;
    }

}
